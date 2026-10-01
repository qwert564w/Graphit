package ru.dreamix.protection.api.impl.profile;

import ru.dreamix.protection.api.impl.profile.models.ProfileInformationModel;
import ru.dreamix.protection.api.impl.profile.objects.RoleObject;

public class ProfileAPI {
    // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
    private static final ProfileAPI instance = new ProfileAPI();
    private final ProfileInformationModel model = new ProfileInformationModel();

    public static void create(String name, int id, RoleObject role) {
    }

    public static ProfileAPI get() {
        return instance;
    }

    public ProfileInformationModel getModel() {
        return model;
    }
}
