package co.com.colcomercio.siga.utils;

import co.com.colcomercio.siga.models.users.Users;


import java.util.List;

public class GetDataModel {
    private GetDataModel() {
    }

    public static Users user(String key) {
        List<Users> data = MyReader.ofInformationWith("src/test/resources/data/users.json")
                .andModel(Users.class);
        return data.stream().filter(t -> t.getKey().equals(key)).findFirst().get();
    }


}
