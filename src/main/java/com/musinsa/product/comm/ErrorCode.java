package com.musinsa.product.comm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_INPUT(400,"E400","잘못된 요청입니다. 요청 값을 확인하세요"),
    SERVER_ERROR(500,"E500","예상치 못한 서버 에러, 관리자에게 문의하세요");

    private final int status;
    private final String code;
    private final String message;
}
