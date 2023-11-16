package com.obsa.quizapp.service;

import com.obsa.quizapp.entity.Question;
import com.obsa.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {

        try {

            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
           e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String>  createQuestion(Question question) {
        questionDao.save(question);
        try {
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("Hin taane Kiristinnaan Badhaanee", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>>  getQuestionByCategory(String category) {

        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }



    public String deleteQuestionById(Integer id) {
        questionDao.deleteById(id);
        return "Success Question Deleted";
    }



//    public List<Question> updateQuestion(Question question) {
//        return questionDao.save(question);
//    }
}
