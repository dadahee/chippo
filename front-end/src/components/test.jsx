import React from 'react';
import { Button } from '@chakra-ui/button';

function Test(){
    return (
        <div>
            <Button variant = "primary">primary</Button>
            <Button variant = "solid" bg = "secondary">secondary</Button>
            <Button variant = "solid" bg = "danger">danger</Button>
        </div>
    )
}

export default Test;