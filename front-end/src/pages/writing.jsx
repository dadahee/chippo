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
    Flex,
    Container
  } from '@chakra-ui/react'

function Writing({ logined }){

    const navigator = useNavigate();
    
    if (logined === false) navigator("/login");
    
      return (
          <Center>
            <VStack w ="70%">
                <Flex w = "100%">
                    <Form>
                        <FormikExample />
                    </Form>
                    
                </Flex>
            </VStack>
            
          </Center>
          
      )
    
}

function FormikExample() {
    function validateName(value) {
        let error
        if (!value) error = 'Name is required'
        else if (value.toLowerCase() !== 'naruto') error = "Jeez! You're not a fan 😱"
      
        return error
    }
  
    return (
      <Formik
        initialValues={{ name: 'Sasuke' }}
        onSubmit={(values, actions) => {
          setTimeout(() => {
            alert(JSON.stringify(values, null, 2))
            actions.setSubmitting(false)
          }, 1000)
        }}
      >
        {(props) => (
          
            <Field name='name' validate={validateName}>
              {({ field, form }) => (
                <FormControl isInvalid={form.errors.name && form.touched.name}>
                  <FormLabel htmlFor='name'>First name</FormLabel>
                  <Input {...field} id='name' placeholder='name' />
                  <FormErrorMessage>{form.errors.name}</FormErrorMessage>
                </FormControl>
              )}
            </Field>
          
        )}
      </Formik>
    )
  }

const mapStateToProps = ({ logined }) => {
    return {
        logined : logined.login
    }
}

export default connect(mapStateToProps)(Writing);