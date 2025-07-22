package com.marcom.interview_taks.config;

public class Constant {

    public static class ResponseCode {

        public static class Success {
            public static final int CODE = 0;
            public static final String MSG = "Success";
        }

        public static class Failure {
            public static final int UNKNOWN_ERROR = 1000;
            public static final String UNKNOWN_ERROR_MSG = "Unknown error occurred";

            public static final int BAD_REQUEST = 1001;
            public static final String BAD_REQUEST_MSG = "Bad request";

            public static final int UNAUTHORIZED = 1002;
            public static final String UNAUTHORIZED_MSG = "Unauthorized access";

            public static final int FORBIDDEN = 1003;
            public static final String FORBIDDEN_MSG = "Forbidden";

            public static final int NOT_FOUND = 1004;
            public static final String NOT_FOUND_MSG = "Resource not found";

            public static final int SERVER_ERROR = 1005;
            public static final String SERVER_ERROR_MSG = "Internal server error";

            public static final int SERVICE_UNAVAILABLE = 1006;
            public static final String SERVICE_UNAVAILABLE_MSG = "Service temporarily unavailable";
        }
    }
}

