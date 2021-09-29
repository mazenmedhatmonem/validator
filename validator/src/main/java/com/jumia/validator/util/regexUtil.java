package com.jumia.validator.util;

import com.jumia.validator.bo.CountryBo;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public  class regexUtil {

 public static  Map<String, CountryBo> regexCountryCodeMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, CountryBo>("237", new CountryBo("237", "Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$")),
            new AbstractMap.SimpleEntry<String, CountryBo>("251", new CountryBo("251", "Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$")),
            new AbstractMap.SimpleEntry<String, CountryBo>("212", new CountryBo("212", "Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$")),
            new AbstractMap.SimpleEntry<String, CountryBo>("258", new CountryBo("258", "Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$")),
            new AbstractMap.SimpleEntry<String, CountryBo>("256", new CountryBo("256", "Uganda", "\\(256\\)\\ ?\\d{9}$")));
}
