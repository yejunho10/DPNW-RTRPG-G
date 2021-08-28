package com.dpnw.rtrpg.prefix.adjective;

import com.dpnw.rtrpg.prefix.enums.PrefixName;
import com.dpnw.rtrpg.prefix.enums.PrefixType;
import com.dpnw.rtrpg.prefix.obj.PrefixImpl;

public class Idiot extends PrefixImpl {
    public Idiot() {
        setPrefixType(PrefixType.ADJECTIVE);
        setPrefixName(PrefixName.IDIOT);
        setPrefixDisplay("멍청한");
        setDamage(10);
    }
}
