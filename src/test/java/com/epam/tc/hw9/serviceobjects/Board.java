package com.epam.tc.hw9.serviceobjects;

import static io.restassured.RestAssured.given;

import com.epam.tc.hw9.test.BaseTestAPI;
import io.restassured.response.Response;

public class Board {

    /** Path. */
    private static final String BOARDS_PATH = "/1/boards";
    private static final String BOARD_ID = "/1/boards/{id}";

    /** Path parameters. */
    public static String pathParamId = "id";
    public static String pathParamName = "name";
    public static String pathParamDescription = "desc";

    /** Query parameters. */
    public static String queryParamName = "name";


    /** Board body keys. */
    public static String boardBodyKeyId = "id";
    public static String boardBodyKeyName = "name";
    public static String boardBodyKeyDesc = "desc";

    public static Response createNewBoard(String boardName, String boardDesciption) {
        return given()
            .spec(BaseTestAPI.baseRequestSpecification)
            .basePath(BOARDS_PATH)
            .when()
            .queryParam(pathParamName, boardName)
            .queryParam(pathParamDescription, boardDesciption)
            .post()
            .then()
            .extract().response();
    }

    public static Response createNewBoardForListFlow(String boardName) {
        return given()
            .spec(BaseTestAPI.baseRequestSpecification)
            .basePath(BOARDS_PATH)
            .when()
            .queryParam(pathParamName, boardName)
            .post()
            .then()
            .extract().response();
    }

    public static Response getBoard(String boardId) {
        return given()
            .spec(BaseTestAPI.baseRequestSpecification)
            .when()
            .basePath(BOARD_ID)
            .pathParam(pathParamId, boardId)
            .get()
            .then()
            .extract().response();
    }

    public static Response updateBoard(String boardId, String newBoardName) {
        return given()
            .spec(BaseTestAPI.baseRequestSpecification)
            .when()
            .basePath(BOARD_ID)
            .pathParam(pathParamId, boardId)
            .queryParam(queryParamName, newBoardName)
            .put()
            .then()
            .extract().response();
    }

    public static Response deleteBoard(String boardId) {
        return given()
            .spec(BaseTestAPI.baseRequestSpecification)
            .when()
            .basePath(BOARD_ID)
            .pathParam(pathParamId, boardId)
            .delete()
            .then()
            .extract().response();
    }

}