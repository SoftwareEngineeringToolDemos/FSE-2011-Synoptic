package synoptic.util;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

import synoptic.main.ParseException;

public class InternalSynopticException extends RuntimeException implements
        Serializable {
    /**
     * Unique version uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * Conflicting regular expression
     */
    private String regex;

    /**
     * Conflicting log entry
     */
    private String logLine;

    private ParseException parseException;

    /**
     * The human readable message to display, in the case that we are not
     * wrapping a java exception.
     */
    String errMessage = null;

    /**
     * The stack trace for this exception -- initialized in the constructors.
     */
    String stackTrace = "";

    /**
     * Create an exception based on some internal error.
     * 
     * @param errMsg
     *            Error message to display to the user
     */
    public InternalSynopticException(String errMsg) {
        errMessage = errMsg;
        StringWriter sw = new StringWriter();
        super.printStackTrace(new PrintWriter(sw));
        stackTrace = sw.toString();
    }

    /**
     * Create an internal exception based on a Java exception
     * 
     * @param e
     *            Some Java exception
     */
    public InternalSynopticException(Exception e) {
        if (e instanceof ParseException) {
            ParseException pe = (ParseException) e;
            setParseException(pe);
        }
        errMessage = e.getMessage();
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        stackTrace = sw.toString();
    }

    @Override
    public String getMessage() {
        return errMessage;
    }

    /**
     * Create an internal exception wrapper around a Java exception. Unless the
     * exception itself is an internal exception.
     * 
     * @param e
     *            Some Java exception
     * @return a InternalSynopticException wrapper for the Java exception
     */
    public static InternalSynopticException wrap(Exception e) {
        if (e instanceof InternalSynopticException) {
            return (InternalSynopticException) e;
        }
        return new InternalSynopticException(e);
    }

    @Override
    public String toString() {
        String ret = "Internal error, notify developers.\n";

        if (errMessage != null) {
            ret += "Error: " + errMessage + "\n";
        }
        ret += "Error traceback:\n";
        ret += stackTrace;
        return ret;
    }

    /**
     * @return Nullable string describing conflicting regular expression
     */
    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public boolean hasRegex() {
        return regex != null;
    }

    public String getLogLine() {
        return logLine;
    }

    public void setLogLine(String logLine) {
        this.logLine = logLine;
    }

    public boolean hasLogLine() {
        return logLine != null;
    }

    public boolean hasParseException() {
        return parseException != null;
    }

    public void setParseException(ParseException pe) {
        this.parseException = pe;
    }

    public ParseException getParseException() {
        return parseException;
    }

}
