package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.entity.Member;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.entity.UserProfile;
import za.ac.cput.entity.enums.RoleType;
import za.ac.cput.factory.MemberFactory;
import za.ac.cput.repository.impl.MemberRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberRepositoryTest {
    private MemberRepositoryImpl repo;
    private Member member1;
    private Member member2;

    @BeforeEach
    void setUp() {
        repo = MemberRepositoryImpl.getRepository();
        repo.delete("MEM01");
        repo.delete("MEM02");

        member1 = MemberFactory.createMember("MEM01,",
                new UserAccount.Builder()
                        .accountId("ACC01")
                        .email("lisakhanya@gmail.com")
                        .password("SecurePassword123")
                        .role(RoleType.MEMBER)
                        .registrationDate(LocalDate.of(2025, 10, 22))
                        .build(),
                new UserProfile.Builder()
                        .profileId("PR001")
                        .firstName("Lisakhanya")
                        .lastName("Tshokolo")
                        .gender("Female")
                        .dateOfBirth(LocalDate.of(2001, 11, 9))
                        .build(),
                new ContactDetails.Builder()
                        .setContactId("CN01")
                        .setCellphoneNumber("0815659910")
                        .setEmergencyContactName("Mom")
                        .setEmergencyContactNumber("0783726156")
                        .build());

        member2 = MemberFactory.createMember("MEM02,",
                new UserAccount.Builder()
                        .accountId("ACC02")
                        .email("ath@gmail.com")
                        .password("ath123")
                        .role(RoleType.TRAINER)
                        .registrationDate(LocalDate.of(2026, 1, 1))
                        .build(),
                new UserProfile.Builder()
                        .profileId("PR002")
                        .firstName("Athi")
                        .lastName("Sintiya")
                        .gender("Male")
                        .dateOfBirth(LocalDate.of(1998, 06, 21))
                        .build(),
                new ContactDetails.Builder()
                        .setContactId("CN02")
                        .setCellphoneNumber("0659812346")
                        .setEmergencyContactName("Dad")
                        .setEmergencyContactNumber("0769375021")
                        .build());


    }

    @Test
    void testGetRepository_ReturnsSameInstance() {
        MemberRepositoryImpl instance1 = MemberRepositoryImpl.getRepository();
        MemberRepositoryImpl instance2 = MemberRepositoryImpl.getRepository();
        assertSame(instance1, instance2);
    }

    @Test
    void testCreate_NotNull() {
        Member created = repo.create(member1);
        assertNotNull(created);
    }

    @Test
    void testCreate_ReturnsCorrectMember() {
        Member created = repo.create(member1);
        assertEquals(member1.getMemberId(), created.getMemberId());
    }

    @Test
    void testCreate_StoresMember() {
        repo.create(member1);
        assertNotNull(repo.read("M001"));
    }

    @Test
    void testCreate_CorrectEmail() {
        repo.create(member1);
        assertEquals("lisakhanya@gmail.com", repo.read("M001").getAccount().getEmail());
    }

    @Test
    void testCreate_CorrectRole() {
        repo.create(member1);
        assertEquals(RoleType.MEMBER, repo.read("M001").getAccount().getRole());
    }

    @Test
    void testCreate_CorrectFirstName() {
        repo.create(member1);
        assertEquals("Lisakhanya", repo.read("M001").getProfile().getFirstName());
    }

    @Test
    void testCreate_CorrectCellphoneNumber() {
        repo.create(member1);
        assertEquals("0815659910", repo.read("M001").getContact().getCellphoneNumber());
    }

    @Test
    void testCreate_MultipleMembers() {
        repo.create(member1);
        repo.create(member2);
        assertNotNull(repo.read("M001"));
        assertNotNull(repo.read("M002"));
    }


    @Test
    void testRead_ExistingMember_NotNull() {
        repo.create(member1);
        assertNotNull(repo.read("M001"));
    }

    @Test
    void testRead_ExistingMember_CorrectMemberId() {
        repo.create(member1);
        assertEquals("M001", repo.read("M001").getMemberId());
    }

    @Test
    void testRead_ExistingMember_CorrectEmail() {
        repo.create(member1);
        assertEquals("lisakhanya@gmail.com", repo.read("M001").getAccount().getEmail());
    }

    @Test
    void testRead_ExistingMember_CorrectPassword() {
        repo.create(member1);
        assertEquals("SecurePassword123!", repo.read("M001").getAccount().getPassword());
    }

    @Test
    void testRead_ExistingMember_CorrectRole() {
        repo.create(member1);
        assertEquals(RoleType.MEMBER, repo.read("M001").getAccount().getRole());
    }

    @Test
    void testRead_ExistingMember_CorrectRegistrationDate() {
        repo.create(member1);
        assertEquals(LocalDate.of(2025, 10, 22), repo.read("M001").getAccount().getRegistrationDate());
    }

    @Test
    void testRead_ExistingMember_CorrectFirstName() {
        repo.create(member1);
        assertEquals("Lisakhanya", repo.read("M001").getProfile().getFirstName());
    }

    @Test
    void testRead_ExistingMember_CorrectLastName() {
        repo.create(member1);
        assertEquals("Tshokolo", repo.read("M001").getProfile().getLastName());
    }

    @Test
    void testRead_ExistingMember_CorrectGender() {
        repo.create(member1);
        assertEquals("Female", repo.read("M001").getProfile().getGender());
    }

    @Test
    void testRead_ExistingMember_CorrectDateOfBirth() {
        repo.create(member1);
        assertEquals(LocalDate.of(2001, 11, 9), repo.read("M001").getProfile().getDateOfBirth());
    }

    @Test
    void testRead_ExistingMember_CorrectCellphoneNumber() {
        repo.create(member1);
        assertEquals("0815659910", repo.read("M001").getContact().getCellphoneNumber());
    }

    @Test
    void testRead_ExistingMember_CorrectEmergencyContactName() {
        repo.create(member1);
        assertEquals("Mom", repo.read("M001").getContact().getEmergencyContactName());
    }

    @Test
    void testRead_ExistingMember_CorrectEmergencyContactNumber() {
        repo.create(member1);
        assertEquals("0783726156", repo.read("M001").getContact().getEmergencyContactNumber());
    }

    @Test
    void testRead_NonExistentMember_ReturnsNull() {
        assertNull(repo.read("DOES_NOT_EXIST"));
    }


    @Test
    void testUpdate_NotNull() {
        repo.create(member1);
        member1.setProfile(new UserProfile.Builder()
                .profileId("P001")
                .firstName("Updated")
                .lastName("Name")
                .gender("Female")
                .dateOfBirth(LocalDate.of(2001, 11, 9))
                .build());
        assertNotNull(repo.update(member1));
    }

    @Test
    void testUpdate_CorrectFirstName() {
        repo.create(member1);
        member1.setProfile(new UserProfile.Builder()
                .profileId("P001")
                .firstName("Updated")
                .lastName("Name")
                .gender("Female")
                .dateOfBirth(LocalDate.of(2001, 11, 9))
                .build());
        repo.update(member1);
        assertEquals("Updated", repo.read("M001").getProfile().getFirstName());
    }

    @Test
    void testUpdate_CorrectCellphoneNumber() {
        repo.create(member1);
        member1.setContact(new ContactDetails.Builder()
                .setCellphoneNumber("0815659910")
                .setEmergencyContactNumber("0783726156")
                .setEmergencyContactName("Mom")
                .build());
        repo.update(member1);
        assertEquals("0815659910", repo.read("M001").getContact().getCellphoneNumber());
    }

    @Test
    void testUpdate_NonExistentMember_ReturnsNull() {
        assertNull(repo.update(member1));
    }


    @Test
    void testDelete_ExistingMember_ReturnsTrue() {
        repo.create(member1);
        assertTrue(repo.delete("M001"));
    }

    @Test
    void testDelete_ExistingMember_NoLongerExists() {
        repo.create(member1);
        repo.delete("M001");
        assertNull(repo.read("M001"));
    }

    @Test
    void testDelete_NonExistentMember_ReturnsFalse() {
        assertFalse(repo.delete("DOES_NOT_EXIST"));
    }


    @Test
    void testGetAll_NotNull() {
        assertNotNull(repo.getAll());
    }

    @Test
    void testGetAll_ReturnsAllMembers() {
        repo.create(member1);
        repo.create(member2);
        List<Member> all = repo.getAll();
        assertEquals(2, all.size());
    }

    @Test
    void testGetAll_EmptyStore_ReturnsEmptyList() {
        List<Member> all = repo.getAll();
        assertTrue(all.isEmpty());
    }

    @Test
    void testGetAll_ContainsCreatedMember() {
        repo.create(member1);
        assertTrue(repo.getAll().stream()
                .anyMatch(m -> m.getMemberId().equals("M001")));
    }
}