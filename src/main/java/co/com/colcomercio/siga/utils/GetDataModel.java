package co.com.colcomercio.siga.utils;

import co.com.colcomercio.siga.models.users.Negocio;
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

    public static Negocio negocio(String key) {
        List<Negocio> data = MyReader.ofInformationWith("src/test/resources/data/negocio.json")
                .andModel(Negocio.class);
        return data.stream().filter(t -> t.getKey().equals(key)).findFirst().get();
    }


}
