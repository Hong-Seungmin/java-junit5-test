package com.example.javatest.study;

import com.example.javatest.domain.Member;
import com.example.javatest.domain.Study;
import com.example.javatest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService() {

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("hong@gmail.com");

        Study study = new Study(10, "java");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);


        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(memberService.findById(2L)).thenReturn(null);


        Optional<Member> findById = memberService.findById(1L);
        assertEquals("hong@gmail.com", findById.get().getEmail());
        Optional<Member> findById2 = memberService.findById(2L);
        assertNull(findById2);
        studyService.createNewStudy(1L, study);

        doThrow(new IllegalArgumentException()).when(memberService).validate(3L);

        assertThrows(IllegalArgumentException.class, ()-> memberService.validate(3L));

        Optional<Member> optionalMember = memberService.findById(1L);
        memberService.validate(2L);

        assertNotNull(studyService);

        verify(memberService,times(1)).notify(study);
//        verify(memberService, never()).validate(any());

    }


}