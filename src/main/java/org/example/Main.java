package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch();
//            Page page = browser.newPage();
//            page.navigate("http://playwright.dev");
//            System.out.println(page.title());
//        }

        //Launch a browser
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
//            Page page = browser.newPage();
//            page.navigate("https://playwright.dev/");
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
//        }

        Playwright playwright = Playwright.create();

        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");         // Channel can be "chrome", "msedge", "chrome-beta", "msedge-beta" or "msedge-dev".
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);          //firefox()   chromium()
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com");

        String title = page.title();
        System.out.println("page title is : "+ title);

        String url = page.url();
        System.out.println("url is : " + url);

        browser.close();
        playwright.close();
    }
}