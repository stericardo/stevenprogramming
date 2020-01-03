package com.stevenprogramming.liquibase.controllers;

import com.stevenprogramming.liquibase.config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GreetingControllerTest extends BaseTest
{

    @Test
    @DisplayName( "GreetingControllerTest Welcome1" )
    public void welcome1Test()throws Exception{
        MvcResult mvcResult = this.mockMvc.perform( get( "/welcome" ) )
                .andDo( print() ).andExpect( status().isOk() )
                //.andExpect( content().string( "pong" ) )
                .andReturn();
    }

    @Test
    @DisplayName( "GreetingControllerTest Welcome2" )
    public void welcome2Test()throws Exception{
        MvcResult mvcResult = this.mockMvc.perform( get( "/welcomefine" ) )
                .andDo( print() ).andExpect( status().isOk() )
                //.andExpect( content().string( "pong" ) )
                .andReturn();
    }


}
