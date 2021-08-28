package com.dpnw.rtrpg.prefix.obj;

import com.dpnw.rtrpg.prefix.enums.PrefixName;
import com.dpnw.rtrpg.prefix.enums.PrefixType;

public class PrefixImpl extends PrefixPublicFields implements Prefix {
    private PrefixType prefixType;
    private PrefixName prefixName;
    private String prefixDisplay;

    @Override
    public PrefixType getPrefixType() {
        return prefixType;
    }

    @Override
    public PrefixName getPrefixName() {
        return prefixName;
    }

    @Override
    public String getPrefixDisplay() {
        return prefixDisplay;
    }

    @Override
    public void setPrefixType(PrefixType prefixType) {
        this.prefixType = prefixType;
    }

    @Override
    public void setPrefixName(PrefixName prefixName) {
        this.prefixName = prefixName;
    }

    @Override
    public void setPrefixDisplay(String prefixDisplay) {
        this.prefixDisplay = prefixDisplay;
    }


}
