package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerSeedRootDto;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    private static final String SELLERS_FILE_PATH = "src/main/resources/files/xml/sellers.xml";

    private final SellerRepository sellerRepository;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public SellerServiceImpl(SellerRepository sellerRepository, ValidationUtil validationUtil, XmlParser xmlParser, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files
                .readString(Path.of(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        SellerSeedRootDto sellerSeedRootDto = this.xmlParser
                .readFromFilePath(SELLERS_FILE_PATH, SellerSeedRootDto.class);

        StringBuilder sb = new StringBuilder();
        sellerSeedRootDto.getSellers()
                .stream()
                .filter(sellerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(sellerSeedDto);
                    sb
                            .append(isValid
                            ? String.format("Successfully import seller %s - %s",
                                    sellerSeedDto.getLastName(),
                                    sellerSeedDto.getEmail())
                            : "Invalid seller")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(sellerSeedDto -> this.modelMapper.map(sellerSeedDto, Seller.class))
                .forEach(this.sellerRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Seller findById(Long id) {
        return this.sellerRepository
                .findById(id)
                .orElse(null);
    }
}
