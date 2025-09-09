package com.example.floword;

public class Response {
    private String reason;
    private ResultDTO result;
    private Integer error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public static class ResultDTO {
        private String title;
        private String birthday;
        private String name;
        private String name_des;
        private String lang;
        private String lang_des;
        private String stone;
        private String stone_des;
        private String legend;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_des() {
            return name_des;
        }

        public void setName_des(String name_des) {
            this.name_des = name_des;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getLang_des() {
            return lang_des;
        }

        public void setLang_des(String lang_des) {
            this.lang_des = lang_des;
        }

        public String getStone() {
            return stone;
        }

        public void setStone(String stone) {
            this.stone = stone;
        }

        public String getStone_des() {
            return stone_des;
        }

        public void setStone_des(String stone_des) {
            this.stone_des = stone_des;
        }

        public String getLegend() {
            return legend;
        }

        public void setLegend(String legend) {
            this.legend = legend;
        }
    }
}
