package pageObjects;

public class PageObjectManager {

    private RiaHomePage riaHomePage;
    private RiaResultPage riaResultPage;
    private RiaProductPage riaProductPage;
    private RiaBrandPage riaBrandPage;

    public RiaHomePage getRiaHomePage() {
        return (riaHomePage == null) ? riaHomePage = new RiaHomePage() : riaHomePage;
    }
    public RiaResultPage getRiaResultPage() {
        return (riaResultPage == null) ? riaResultPage = new RiaResultPage() : riaResultPage;
    }
    public RiaProductPage getRiaProductPage() {
        return (riaProductPage == null) ? riaProductPage = new RiaProductPage() : riaProductPage;
    }
    public RiaBrandPage getRiaBrandPage() {
        return (riaBrandPage == null) ? riaBrandPage = new RiaBrandPage() : riaBrandPage;
    }
}