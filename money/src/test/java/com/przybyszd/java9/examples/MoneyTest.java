package com.przybyszd.java9.examples;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryFunctions;
import org.junit.Test;

import javax.money.*;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRate;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void createSimpleCurrencyTest() {
        CurrencyUnit pln = Monetary.getCurrency("PLN");
        assertNotNull(pln);
        assertEquals("PLN", pln.getCurrencyCode());
        assertEquals(2, pln.getDefaultFractionDigits());
        assertEquals(985, pln.getNumericCode());
    }

    @Test
    public void normalAndFastMoneyTest() {
        CurrencyUnit usd = Monetary.getCurrency(Locale.US);
        MonetaryAmount normal = Money.of(new BigDecimal("1.5"), usd);
        MonetaryAmount fast = FastMoney.of(new BigDecimal("1.5"), usd);
        assertEquals("USD 1.5", normal.toString());
        assertEquals("USD 1.50000", fast.toString());
    }

    @Test
    public void moneyFormatterTest() {
        CurrencyUnit usd = Monetary.getCurrency(Locale.US);
        MonetaryAmount money = Money.of(new BigDecimal("1.5"), usd);
        MonetaryAmountFormat format = MonetaryFormats.getAmountFormat(new Locale("pl_PL"));
        assertEquals("USD 1.50", format.format(money));
    }


    @Test
    public void moneyOperationsTest() {
        CurrencyUnit usd = Monetary.getCurrency(Locale.US);
        MonetaryAmount m1 = Money.of(new BigDecimal("1.5"), usd);
        MonetaryAmount m2 = Money.of(new BigDecimal("3.59"), usd);
        assertEquals(Money.of(new BigDecimal("5.09"), usd), m1.add(m2));
        assertEquals(Money.of(new BigDecimal("3"), usd), m1.multiply(2));
        assertTrue(m1.isLessThan(m2));
    }

    @Test
    public void moneyFunctionsTest() {
        CurrencyUnit usd = Monetary.getCurrency(Locale.US);
        CurrencyUnit pln = Monetary.getCurrency("PLN");
        MonetaryAmount m1 = Money.of(new BigDecimal("1.5"), usd);
        MonetaryAmount m2 = Money.of(new BigDecimal("3.59"), usd);
        MonetaryAmount m3 = Money.of(new BigDecimal("2.50"), pln);
        assertEquals(Optional.of(
                        Money.of(new BigDecimal("5.09"), usd)),
                Arrays.asList(m1, m2, m3)
                        .stream()
                        .filter(MonetaryFunctions.isCurrency(usd))
                        .reduce(MonetaryFunctions.sum()));
    }

    @Test
    public void exchangeTest() {
//        ExchangeRateProvider imfRateProvider = MonetaryConversions
//                .getExchangeRateProvider("IMF");
//        ExchangeRateProvider ecbRateProvider = MonetaryConversions
//                .getExchangeRateProvider("ECB");
//
//        CurrencyUnit real = Monetary.getCurrency("BRL");
//        CurrencyUnit dollar = Monetary.getCurrency(Locale.US);
//
//        CurrencyConversion ecbDollarConvertion = ecbRateProvider
//                .getCurrencyConversion(dollar);
//
//        CurrencyConversion imfDollarConvertion = imfRateProvider
//                .getCurrencyConversion(dollar);
//
//        MonetaryAmount money = Money.of(10, real);
//        System.out.println(money.with(ecbDollarConvertion));
//        System.out.println(money.with(imfDollarConvertion));

        CurrencyUnit usd = Monetary.getCurrency(Locale.US);
        CurrencyUnit pln = Monetary.getCurrency("PLN");
        //ExchangeRateProvider imfRateProvider = MonetaryConversions.getExchangeRateProvider("IMF");

        ExchangeRateProvider ecbRateProvider = MonetaryConversions.getExchangeRateProvider("ECB");
        ExchangeRate exchangeRate = ecbRateProvider.getExchangeRate("PLN", "USD");
        NumberValue factor = exchangeRate.getFactor(); //0.27369381044951642996

        CurrencyConversion currencyConversion = ecbRateProvider.getCurrencyConversion(usd);
        Money m = Money.of(5, pln).with(currencyConversion);
        System.out.println(m.equals(Money.of(new BigDecimal("1.3684690522475821498"), usd)));

        Money.of(new
                BigDecimal("1.3684690522475821498"), usd);

        MonetaryRounding rounding = Monetary.
                getRounding(RoundingQueryBuilder.of()
                        .setCurrency(usd).build());
        assertEquals(Money.of(new
                        BigDecimal("1.37"), usd),
                rounding.apply(Money.of(new
                        BigDecimal("1.3684690522475821498"), usd))
        );

    }

    @Test
    public void test() throws ScriptException {
        ScriptEngineManager m = new
                ScriptEngineManager();
        ScriptEngine e =
                m.getEngineByName("nashorn");

        ScriptObjectMirror o = (ScriptObjectMirror) e.eval("JSON.parse('{\"name\":\"John\"}');");
        assertEquals("John", o.getMember("name"));

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader r = reader) {
            // ...
        } catch (IOException ex) {
            // ...
        }
    }
}
