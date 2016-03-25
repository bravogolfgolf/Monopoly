package pkg.board.domain;

import java.io.IOException;
import java.util.List;

public interface SpaceFactory {

    List<Space> load(String localization) throws IOException;
}
