import React from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';

import { useNavigate } from 'react-router-dom';

import { connect } from "react-redux";

import {
    FormControl,
    FormLabel,
    FormErrorMessage,
    FormHelperText,
    Input,
    Button,
    Center,
    VStack,
    Box,
    Flex,
    Spacer,
    Container
  } from '@chakra-ui/react'

function Writing({ logined }){

    const checkKorean = (value) => {
        let error;
        if (!/^[가-힣]+$/.test(value)){
            error = "한국어로 입력하세요"
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
                                type="text" placeholder="30자 이내로 입력하세요" maxLength="40" />
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
                    
                    <Button variant="primary" type="submit">Submit</Button>
                    </VStack>
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