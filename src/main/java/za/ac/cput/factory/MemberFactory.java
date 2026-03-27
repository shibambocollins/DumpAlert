package za.ac.cput.factory;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.entity.Member;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.entity.UserProfile;
import za.ac.cput.util.helper;

/**
 *
 * 25 March 2026
 * Author: Lisakhanya Tshokolo
 * (220239215)
 */

import java.util.UUID;

public class MemberFactory {
    public static Member createMember(String memberId, UserAccount account, UserProfile profile, ContactDetails contact){
        memberId =  UUID.randomUUID().toString();
        if(helper.isNullOrEmpty(memberId))
            throw new NullPointerException("Member ID is required");
        if (helper.isNullOrEmpty(String.valueOf(account)))
            throw new NullPointerException("Account is required");
        if (helper.isNullOrEmpty(String.valueOf(profile)))
            throw new NullPointerException("Profile is required");
        if (helper.isNullOrEmpty(String.valueOf(contact)))
            throw new NullPointerException("Contact details is required");

        return new Member.Builder().memberId(memberId)
                .account(account)
                .profile(profile)
                .contact(contact)
                .build();
    }
}
