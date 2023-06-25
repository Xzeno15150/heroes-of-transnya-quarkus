
package fr.multiplatform.hot.resources.dtos.delete;

import com.mongodb.client.result.DeleteResult;

public class DeleteResponse {
    private DeleteResult deleteResult;
  
    public DeleteResponse() {
    }

    public DeleteResponse(DeleteResult deleteResult) {
        this.deleteResult = deleteResult;
    }

    public DeleteResult getDeleteResult() {
        return deleteResult;
    }

    public DeleteResponse setDeleteResult(DeleteResult deleteResult) {
        this.deleteResult = deleteResult;
        return this;
    }
}

