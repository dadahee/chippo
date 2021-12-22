import React from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';

import { useNavigate } from 'react-router-dom';

import { connect } from "react-redux";

import {
    FormControl,
    FormLabel,
    FormErrorMessage,
    Input,
    Button,
    Center,
    VStack,
    Box,
    Select,
    Textarea,
  } from '@chakra-ui/react'

import {
    SelectControl,
    TextareaControl
} from "formik-chakra-ui";

function Writing({ logined }){

    const checkKorean = (value) => {
        let error;
        if (!/^[가-힣]+$/.test(value)){
            error = "한국어로 입력하세요"
        }

        return error;
    }

    const checkEnglish = (value) => {
        let error;
        if (!/^[A-Z|a-z]+$/){
            error = "영어로 입력하세요"
        }

        return error;
    }

    const navigator = useNavigate();
    
    if (logined === false) navigator("/login");
    
    return (
        <Center>
        <VStack w ="70%">
            <Box w = "100%">
            <Formik
                initialValues={{
                    question: '',
                    company: '',
                    stack1 : '',
                    stack2 : '',
                    stack3 : '',
                    job: '',
                    answer : '',
                    additionalInformation : '',

                }}

                onSubmit={async (values) => {
                    await new Promise((r) => setTimeout(r, 500));
                    alert(JSON.stringify(values, null, 2));
                }}
            >
                <Form>
                    <VStack spacing={12}>
                    <Field
                        name="question"
                        render={({ field, form: { isSubmitting } }) => (
                            <FormControl>
                            <FormLabel htmlFor="question">면접 질문</FormLabel>
                            <Input {...field} disabled={isSubmitting} 
                                type="text" placeholder="30자 이내로 입력하세요" maxLength="40" 
                                colorScheme="#5078E7" />
                            </FormControl> 
                        )}
                    />
                    
                    <Field
                        name="company" validate = {checkKorean}
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.company && touched.company}>
                                <FormLabel htmlFor="company">기업명</FormLabel>
                                <Input {...field} disabled={isSubmitting} 
                                    type="text" placeholder="한글로 작성 ex) 카카오, 네이버" />
                                <FormErrorMessage>{errors.company}</FormErrorMessage>
                            </FormControl>
                        )}
                    />

                    <Field
                        name="stack1" validate = {checkEnglish}
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.stack1 && touched.stack1}>
                                <FormLabel htmlFor="stack1">스택1</FormLabel>
                                <Input {...field} disabled={isSubmitting} 
                                    type="text" name = "stack1" list = "stack1" />
                                <datalist id="stack1">
                                    <option value="컴퓨터공학과"></option>
                                    <option value="영어영문과"></option>
                                    <option value="경영학과"></option>
                                    <option value="사회체육과"></option>
                                </datalist>
                                <FormErrorMessage>{errors.stack1}</FormErrorMessage>
                            </FormControl>
                        )}
                    />

                    <Field
                        name="stack2" validate = {checkEnglish}
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.stack2 && touched.stack2}>
                                <FormLabel htmlFor="stack2">스택2</FormLabel>
                                <Input {...field} disabled={isSubmitting} 
                                    type="text" name = "stack2" list = "stack2" />
                                <datalist id="stack2">
                                    <option value="컴퓨터공학과"></option>
                                    <option value="영어영문과"></option>
                                    <option value="경영학과"></option>
                                    <option value="사회체육과"></option>
                                </datalist>
                                <FormErrorMessage>{errors.stack2}</FormErrorMessage>
                            </FormControl>
                        )}
                    />

                    <Field
                        name="stack3" validate = {checkEnglish}
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.stack1 && touched.stack1}>
                                <FormLabel htmlFor="stack3">스택3</FormLabel>
                                <Input {...field} disabled={isSubmitting} 
                                    type="text" name = "stack3" list = "stack3" />
                                <datalist id="stack3">
                                    <option value="컴퓨터공학과"></option>
                                    <option value="영어영문과"></option>
                                    <option value="경영학과"></option>
                                    <option value="사회체육과"></option>
                                </datalist>
                                <FormErrorMessage>{errors.stack3}</FormErrorMessage>
                            </FormControl>
                        )}
                    />

                    <Field
                        name="job" validate = {checkEnglish}
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.job && touched.job}>
                                <FormLabel htmlFor="job">직무</FormLabel>
                                <Input {...field} disabled={isSubmitting} w = "300px"
                                    type="text" name = "job" list = "job" />
                                <datalist id="job">
                                    <option value="컴퓨터공학과"></option>
                                    <option value="영어영문과"></option>
                                    <option value="경영학과"></option>
                                    <option value="사회체육과"></option>
                                </datalist>
                                <FormErrorMessage>{errors.job}</FormErrorMessage>
                            </FormControl>
                        )}
                    />

                    <Field
                        name="answer"
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.answer && touched.answer}>
                                <Textarea {...field} disabled={isSubmitting} 
                                    type="text" name = "answer" placeholder='내가 생각하는 질문에 대한 답변을 적어주세요!!' />
                                <FormErrorMessage>{errors.answer}</FormErrorMessage>
                            </FormControl>
                        )}
                    />

                    <Field
                        name="additionalInformation" validate = {checkEnglish}
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.additionalInformation && touched.additionalInformation}>
                                <Textarea {...field} disabled={isSubmitting} 
                                    type="text" name = "additionalInformation" placeholder='그 외 추가사항을 입력해주세요' />
                                <FormErrorMessage>{errors.additionalInformation}</FormErrorMessage>
                            </FormControl>
                        )}
                    />
                    

                    </VStack>
                    <Button variant="primary" type="submit">업로드 하기</Button>
                </Form>
                </Formik>
            </Box>
            
            
                    
            
            
        </VStack>
        </Center>
        
    )
    
}


const mapStateToProps = ({ logined }) => {
    return {
        logined : logined.login
    }
}

export default connect(mapStateToProps)(Writing);