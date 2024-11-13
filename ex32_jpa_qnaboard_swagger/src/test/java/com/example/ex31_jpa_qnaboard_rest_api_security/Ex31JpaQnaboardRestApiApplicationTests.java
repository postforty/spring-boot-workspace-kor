// package com.example.ex31_jpa_qnaboard_rest_api_security;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.ex32_jpa_qnaboard_swagger.answer.Answer;
// import com.example.ex32_jpa_qnaboard_swagger.answer.AnswerRepository;
// import com.example.ex32_jpa_qnaboard_swagger.question.Question;
// import com.example.ex32_jpa_qnaboard_swagger.question.QuestionRepository;
// import com.example.ex32_jpa_qnaboard_swagger.question.QuestionService;

// // import jakarta.transaction.Transactional;

// @SpringBootTest
// class Ex31JpaQnaboardRestApiApplicationTests {

// @Test
// void contextLoads() {
// System.out.println(">>> testing!");
// }

// @Autowired
// private QuestionRepository questionRepository;

// @Test
// void testJpaQuestionSave() {
// Question q1 = new Question();
// q1.setSubject("sbb가 무엇인가요?");
// q1.setContent("sbb에 대해서 알고 싶습니다.");
// q1.setCreateDate(LocalDateTime.now());
// this.questionRepository.save(q1); // 첫번째 질문 저장

// Question q2 = new Question();
// q2.setSubject("스프링부트 모델 질문입니다.");
// q2.setContent("id는 자동으로 생성되나요?");
// q2.setCreateDate(LocalDateTime.now());
// this.questionRepository.save(q2); // 두번째 질문 저장
// }

// @Test
// void testJpaQuestionFindAll() {
// List<Question> all = this.questionRepository.findAll();
// assertEquals(2, all.size());

// Question q = all.get(0);
// assertEquals("sbb가 무엇인가요?", q.getSubject());
// }

// @Test
// void testJpaQuestionFindById() {
// Optional<Question> oq = this.questionRepository.findById(2);

// System.out.println(">>> " + oq.get().getSubject());

// if (oq.isPresent()) {
// Question q = oq.get();
// assertEquals("스프링부트 모델 질문입니다.", q.getSubject());
// }
// }

// @Test
// void testJpaQuestionFindBySubject() {
// Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
// assertEquals(1, q.getId());
// }

// @Test
// void testJpaQuestionFindBySubjectAndContent() {
// Question q = this.questionRepository.findBySubjectAndContent(
// "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
// assertEquals(1, q.getId());
// }

// @Test
// void testJpaQuestionFindBySubjectLike() {
// List<Question> qList = this.questionRepository.findBySubjectLike("%sbb%");
// Question q = qList.get(0);
// assertEquals("sbb가 무엇인가요?", q.getSubject());
// }

// @Test
// void testJpaQuestionFindByIdSave() {
// Optional<Question> oq = this.questionRepository.findById(1);
// assertTrue(oq.isPresent());
// Question q = oq.get();
// q.setSubject("수정된 제목");
// this.questionRepository.save(q);
// }

// @Test
// void testJpaQuestionFindByIdDelete() {
// assertEquals(2, this.questionRepository.count());
// Optional<Question> oq = this.questionRepository.findById(1);
// assertTrue(oq.isPresent());
// Question q = oq.get();
// this.questionRepository.delete(q);
// assertEquals(1, this.questionRepository.count());
// }

// @Autowired
// private AnswerRepository answerRepository;

// @Test
// void testJpaAnswerFindByIdSave() {
// Optional<Question> oq = this.questionRepository.findById(2);
// assertTrue(oq.isPresent());
// Question q = oq.get();

// Answer a = new Answer();
// a.setContent("네 자동으로 생성됩니다.");
// a.setQuestion(q); // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
// a.setCreateDate(LocalDateTime.now());
// this.answerRepository.save(a);
// }

// @Test
// void testJpaAnswerFindById() {
// Optional<Answer> oa = this.answerRepository.findById(1);
// assertTrue(oa.isPresent());
// Answer a = oa.get();
// assertEquals(2, a.getQuestion().getId());
// }

// @Transactional
// @Test
// void testJpaQuestionFindByIdAnswer() {
// Optional<Question> oq = this.questionRepository.findById(2);
// assertTrue(oq.isPresent());
// Question q = oq.get();

// List<Answer> answerList = q.getAnswerList();

// assertEquals(1, answerList.size());
// assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
// }

// @Autowired
// private QuestionService questionService;

// // @Test
// // void testJpaAddDummyData() {
// // for (int i = 1; i <= 300; i++) {
// // String subject = String.format("테스트 데이터입니다:[%03d]", i);
// // String content = "내용무";
// // this.questionService.create(subject, content);
// // }
// // }
// }
