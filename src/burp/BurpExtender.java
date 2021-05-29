package burp;
import java.io.PrintWriter;

public class BurpExtender implements IBurpExtender
{
    //
    // implement IBurpExtender
    //
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks)
    {
        // set our extension name
        callbacks.setExtensionName("AuthzCheck");

        PrintWriter stdout = new PrintWriter(callbacks.getStdout(), true);

        stdout.println("Hello World");

        throw new RuntimeException("Hello Exceptions");
    }
}