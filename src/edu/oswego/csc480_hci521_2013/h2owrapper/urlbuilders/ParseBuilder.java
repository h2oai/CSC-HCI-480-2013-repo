package edu.oswego.csc480_hci521_2013.h2owrapper.urlbuilders;

/**
 *
 */
public class ParseBuilder extends AbstractBuilder
{
    public ParseBuilder(String sourceKey)
    {
        super("Parse.json");
        addArg("source_key", sourceKey);
    }

    public ParseBuilder setDestinationKey(String destinationKey)
    {
        addArg("destination_key", destinationKey);
        return this;
    }

    public ParseBuilder setHeader(boolean header)
    {
        if (header) {
            addArg("header", "1");
        }
        else {
            addArg("header", "0");
        }
        return this;
    }
}
