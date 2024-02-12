package com.example.coursework2nd.coursework2nd.service;

import com.example.coursework2nd.coursework2nd.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionServiceImpl implements QuestionService {

    List<Question> questions = new ArrayList<>(List.of(
            new Question("Что светит путникам ночью?", "Луна"),
            new Question("Что нужно делать, когда видишь зелёного человечка?", "Переходить улицу"),
            new Question("По чему ходят часто, а ездят редко?", "По лестнице"),
            new Question("Что это такое: две головы, две руки и шесть ног, а идут только четыре?", "Всадник на коне"),
            new Question("Чем больше из неё берёшь, тем больше она становится.", "Яма")
    ));

    @Override
    public Question add(String question, String answer) {
        if (questions.size() >= 13) {
            throw new IllegalArgumentException("List is already full");
        }
        if (questions.stream().anyMatch(q -> q.getQuestion().equals(question))) {
            throw new IllegalArgumentException("Question already exists in the list");
        } else {
            Question newQuestion = new Question(question, answer);
            questions.add(newQuestion);
            return newQuestion;
        }
    }

    @Override
    public Question add(Question question) {

        if (questions.size() >= 13) {
            throw new IllegalArgumentException("List is already full");
        }
        if (questions.stream().anyMatch(q -> q.getQuestion().equals(question.getQuestion()))) {
            throw new IllegalArgumentException("Question already exists in the list");
        } else {
            questions.add(question);
        }
        return question;
    }

    @Override
    public Question remove(Question question) {

        if (!questions.contains(question)) {
            throw new IllegalArgumentException("Question not found");
        } else {
            questions.remove(question);
            return question;
        }
    }

    @Override
    public Question find(String question) {
        return questions.stream().filter(e -> e.getQuestion().equals(question)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }


}
