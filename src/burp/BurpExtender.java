package burp;
import java.io.PrintWriter;
import net.authzcheck.ui.ACToolPanel;

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

        PrintWriter stderr = new PrintWriter(callbacks.getStderr(), true);

        try{
            callbacks.addSuiteTab(new ACToolPanel(callbacks.getHelpers()));
        }
        catch(Exception ex){
            ex.printStackTrace(stderr);
        }

        throw new RuntimeException("Hello Exceptions!");
    }
}