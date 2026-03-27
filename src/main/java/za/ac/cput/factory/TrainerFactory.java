package za.ac.cput.factory;
import  za.ac.cput.entity.Trainer;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.entity.UserProfile;
import za.ac.cput.util.helper;

import java.util.UUID;

/**
 *
 * 25 March 2026
 * Author: Lisakhanya Tshokolo
 * (220239215)
 */

public class TrainerFactory {
    public static Trainer createTrainer(String trainerId,UserAccount account, UserProfile profile, ContactDetails contact) {
       trainerId = UUID.randomUUID().toString();
        if(helper.isNullOrEmpty(trainerId))
            throw new NullPointerException("Trainer ID is required");
        if (helper.isNullOrEmpty(String.valueOf(account)))
            throw new NullPointerException("Account is required");
        if (helper.isNullOrEmpty(String.valueOf(profile)))
            throw new NullPointerException("Profile is required");
        if (helper.isNullOrEmpty(String.valueOf(contact)))
            throw new NullPointerException("Contact details is required");

        return new Trainer.Builder().setTrainerId(trainerId)
                .setAccount(account)
                .setProfile(profile)
                .setContactDetails(contact)
                .build();

    }
}
