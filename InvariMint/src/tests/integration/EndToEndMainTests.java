package tests.integration;

import java.io.File;

import main.InvariMintMain;

import org.junit.Test;

import tests.InvariMintTest;

/**
 * Runs the DFAMain project end-to-end on a different log files.
 * 
 * @author ivan
 */
public class EndToEndMainTests extends InvariMintTest {

    /**
     * Test on osx-login-example in traces/abstract/.
     * 
     * @throws Exception
     */
    @Test
    public void abstractLogFileTest() throws Exception {
        String tPath = ".." + File.separator + "traces" + File.separator;
        String loginExamplePath = tPath + "abstract" + File.separator
                + "osx-login-example" + File.separator;

        String[] args = new String[] { "-r", "(?<TYPE>.+)", "-s", "--", "-f",
                testOutputDir + "osx-login-example-dfa-model.png",
                loginExamplePath + "trace.txt" };
        InvariMintMain.main(args);
    }
}