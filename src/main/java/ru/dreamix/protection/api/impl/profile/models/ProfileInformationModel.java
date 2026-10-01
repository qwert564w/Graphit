package ru.dreamix.protection.api.impl.profile.models;

import ru.dreamix.protection.api.impl.profile.objects.RoleObject;

public class ProfileInformationModel {
    // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
    private String name = "cracked by @soezproject ?? src by // @pointdlc @setsprinting @hueglotteam";
    private int userIdentifier = 1337;
    private RoleObject role = RoleObject.ADMIN;
    private SubscriptionObject subscriptionObject = new SubscriptionObject();

    public String getName() {
        return name;
    }

    public int getUserIdentifier() {
        return userIdentifier;
    }

    public RoleObject getRole() {
        return role;
    }

    public SubscriptionObject getSubscriptionObject() {
        return subscriptionObject;
    }
}
