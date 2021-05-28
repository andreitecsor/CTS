package assignments.no3.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NatureDecorator extends ProfileDecorator {
    List<Integer> customElementsIdList = new ArrayList<>();

    public NatureDecorator(Profile profile, Integer... customElementsId) {
        super(profile);
        Collections.addAll(this.customElementsIdList, customElementsId);
        super.setMainTheme(MainTheme.NATURE_LOVER);
    }

    @Override
    public void showProfile() {
        System.out.println(super.getDisplayName() + "-> NATURE_LOVER PROFILE WITH ELEMENTS:" + customElementsIdList);
    }
}
