import React from 'react';
import { Formik, Form, Field, ErrorMessage, FieldArray } from 'formik';

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
    Spacer,
    Flex,
    Select,
    Textarea,
    HStack,
  } from '@chakra-ui/react'

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
        if (!/^[A-Z|a-z|없음]+$/.test(value)){
            error = "영어로 입력하세요"
        }

        return error;
    }

    const checkLength = (value) => {
        let error;
        if (value.length === 0){
            error = "내용을 작성하세요"
        }

        return error;
    } 

    const navigator = useNavigate();
    
    if (logined === false) navigator("/login");
    
    return (
        <>
        <Center>
        <VStack w ="70%">
            <Box w = "100%">
            <Formik
                initialValues={{
                    question: '',
                    company: '',
                    stacks : [''],
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
                            <FormControl isRequired>
                                <Flex>
                                <FormLabel htmlFor="question" w = "100px" pt = "8px">면접 질문</FormLabel>
                                <Input isRequired = {true} {...field} disabled={isSubmitting} w = "600px" variant= "primary"
                                    type="text" placeholder="40자 이내로 입력하세요" maxLength="40" />
                                </Flex>
                            
                            </FormControl> 
                        )}
                    />
                    
                    <Field
                        name="company" validate = {checkKorean}
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.company && touched.company} >
                                <Flex>
                                    <FormLabel htmlFor="company" w = "100px" pt = "8px">기업명</FormLabel>
                                    <Input {...field} disabled={isSubmitting} w = "300px" variant = "primary"
                                        type="text" placeholder="한글로 작성 ex) 카카오, 네이버" />
                                    <FormErrorMessage>{errors.company}</FormErrorMessage>
                                </Flex>
                                
                                
                            </FormControl>
                        )}
                    />

                    <FieldArray name = "stacks"> 
                        
                        {
                            fieldArrayProps => {
                                const { push, pop, form } = fieldArrayProps
                                const { values } = form;
                                const { stacks } = values;
                                
                                return (
                                    <>
                                        <FormControl isRequired >
                                        <Flex w = "100%">
                                        <FormLabel htmlFor="stack" w = "100px" pt = "8px"> 스택 </FormLabel>
                                        
                                            {
                                                stacks.map((stack, index) => {
                                                    return (
                                                        <div key = {index}>
                                                            <Field name = {`stacks[${index}]`} validate = {checkEnglish}
                                                                render = {({ field, form : { isSubmitting, errors, touched } }) => {
                                                                    return (
                                                                        <>
                                                                           <Input {...field} disabled={isSubmitting} 
                                                                           variant="primary" w = "300px" 
                                                                           type="text" name = {`stacks[${index}]`} list = "stackList" />
                                                                           <datalist id="stackList">
                                                                               <option value="python"></option>
                                                                               <option value="javascript"></option>
                                                                               <option value="java"></option>
                                                                               <option value="php"></option>
                                                                               <option value="go"></option>
                                                                               <option value="c"></option>
                                                                               <option value="c#"></option>
                                                                               <option value="c++"></option>
                                                                               <option value="없음"></option>
                                                                           </datalist>
                                                                           <FormErrorMessage>{errors.stack1}</FormErrorMessage>
                                                                        </>
                                                                    )
                                                                }}
                                                            />
                                                        </div>
                                                    )
                                                })
                                            }
                                            {
                                                (stacks.length < 2) 
                                                ? <Button type = "button" onClick = {() => push("")}>+</Button>
                                                : (stacks.length < 3) 
                                                ? (
                                                    <>
                                                    <Button type = "button" onClick = {() => push("")}>+</Button>
                                                    <Button type = "button" onClick = {() => pop()}>-</Button>
                                                    </>
                                                )
                                                : <Button type = "button" onClick = {() => pop()}>-</Button>
                                            }
                                            </Flex>
                                        </FormControl>
                                        
                                    </>
                                )
                            }
                        }
                    </FieldArray>

                    <Field
                        name="job" validate = {checkEnglish}
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.job && touched.job}>
                                <Flex>
                                <FormLabel htmlFor="job" w = "100px" pt = "8px">직무</FormLabel>
                                <Input {...field} disabled={isSubmitting} w = "300px"
                                    type="text" name = "job" list = "job"
                                    variant= "primary" />
                                <datalist id="job">
                                    <option value="backend"></option>
                                    <option value="frontend"></option>
                                    <option value="data-engineer"></option>
                                    <option value="ios"></option>
                                    <option value="android"></option>
                                    <option value="없음"></option>
                                </datalist>
                                <FormErrorMessage>{errors.job}</FormErrorMessage>
                                </Flex>
                            </FormControl>
                        )}
                    />

                    

                    <Field
                        name="answer" validate = {checkLength}
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            
                            <FormControl isInvalid = {errors.answer && touched.answer} isRequired>
                                <FormLabel htmlFor="stack" w = "100px"> 제출 답변 </FormLabel>
                                <Textarea {...field} disabled={isSubmitting} 
                                    h = "200px" minLength = "300"
                                    type="text" name = "answer" placeholder='내가 생각하는 질문에 대한 답변을 300자 이내에 적어주세요!!' />
                                <FormErrorMessage>{errors.answer}</FormErrorMessage>
                            </FormControl>
                        )}
                    />

                    <Field
                        name="additionalInformation"
                        render={({ field, form : { isSubmitting, errors, touched } }) => (
                            <FormControl isInvalid = {errors.additionalInformation && touched.additionalInformation}>
                                <Textarea {...field} disabled={isSubmitting} 
                                    type="text" name = "additionalInformation" placeholder='그 외 추가사항을 입력해주세요' />
                                <FormErrorMessage>{errors.additionalInformation}</FormErrorMessage>
                            </FormControl>
                        )}
                    />
                    
                    <Flex w = "100%">
                        <Spacer />
                        <Button variant="primary" w = "300px"  type="submit">수정하기</Button>
                    </Flex>

                    </VStack>
                    
                </Form>
                </Formik>
            </Box>
        </VStack>
        
        
        </Center>
        
        </>
        
    )
    
}


const mapStateToProps = ({ logined }) => {
    return {
        logined : logined.login
    }
}

export default connect(mapStateToProps)(Writing);