package application.sources.sourceDefiner;

import application.readers.Reader;
import application.sources.Sources;

public interface SourceDefiner {
    Sources defineSource(Reader reader);
}
