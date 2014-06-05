package services;

import java.util.List;

import crawler.CrawlControllerFactory;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;

public class SiteCrawler {
	
	private Class<? extends WebCrawler> clazz;
	
	public SiteCrawler(Class<? extends WebCrawler> clazz) {
		this.clazz = clazz;
	}

    public void crawlSite(String url) throws Exception {

        CrawlController controller = CrawlControllerFactory.createController();
        
        System.out.println("visiting url :" + url);
        controller.addSeed(url);
        
        try {
            controller.start(clazz, CrawlControllerFactory.NB_CRAWLERS);
        } finally {
            controller.shutdown();
        }
    }
    
    public void crawlSites(List<String> urls) throws Exception {

        CrawlController controller = CrawlControllerFactory.createController();
        
        for (String url : urls) {
            System.out.println("visiting url :" + url);
            controller.addSeed(url);
        }
        
        try {
            controller.start(clazz, CrawlControllerFactory.NB_CRAWLERS);
        } finally {
            controller.shutdown();
        }
    }
}
