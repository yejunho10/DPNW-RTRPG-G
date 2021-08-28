package com.dpnw.rtrpg.prefix.obj;

import com.dpnw.rtrpg.prefix.enums.PrefixName;
import com.dpnw.rtrpg.prefix.enums.PrefixType;

public interface Prefix {

    PrefixType getPrefixType();

    PrefixName getPrefixName();

    String getPrefixDisplay();

    void setPrefixType(PrefixType prefixType);

    void setPrefixName(PrefixName prefixName);

    void setPrefixDisplay(String prefixDisplay);

}
