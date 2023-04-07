package design.proxy;

public class ProxyBrowser implements IBrowser{
    private String url;
    private Html html;

    public ProxyBrowser(String url) {
        this.url = url;
    }
    @Override
    public Html show() {
        if (html == null) {
            this.html = new Html(url);
            System.out.println("Browser proxy loading html from " + url);
        }
        System.out.println("Browser proxy use cached html");
        return this.html;
    }
}
