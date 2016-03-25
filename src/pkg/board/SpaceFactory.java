package pkg.board;

import java.io.IOException;
import java.util.List;

interface SpaceFactory {

    List<Space> load(String localization) throws IOException;
}
