/*
 *     Copyright 2020 Overnodes. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 *  ================================================================================
 *
 *      Developer : John Koo
 *      Date :      2020-03-04
 *      Contact :   johnkoo@overnodes.com
 *
 *  ================================================================================
 *
 */
package io.autodev.scrapper_api_controller.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.autodev.scrapper_api_controller.pojo.ApiResponse;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiCommunicator {

    public String localIP = "127.0.0.1";
    public String localPort = "8788";

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiCommunicator.class);
    private final static Gson GSON = new GsonBuilder().create();

    private final OkHttpClient httpClient = new OkHttpClient();

    public void getListOfTasks() throws IOException {

        LoggerFactory.getLogger(ApiCommunicator.class).debug("TEST LOGGING");

        Request request = new Request.Builder()
            .url("http://" + localIP + ":" + localPort + "/rest/v1/task/list")
            .build();

        try (Response response = httpClient.newCall(request).execute()){

            if(!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String resString = response.body().string();

            ApiResponse res = GSON.fromJson(resString, ApiResponse.class);

            
        }
    }
}
