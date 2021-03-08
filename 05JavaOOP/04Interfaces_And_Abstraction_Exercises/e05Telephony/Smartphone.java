package Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {

        String regEx = "^[\\d]+$";
        Pattern pattern = Pattern.compile(regEx);

        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()){
                sb.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            } else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        String regEx = "^[\\D]+$";
        Pattern pattern = Pattern.compile(regEx);

        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()){
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
