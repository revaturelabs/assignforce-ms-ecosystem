# assignforce-ms-ecosystem
Assignforce Microservice Refactor

## How to contribute
### Test Driven Development
Make sure that you are creating tests before you write any code.
### Look at projects tab, and assign yourself an issue from the project back-log
Make sure that you use Java naming convention
Add issues that you feel are missing

This line was added for testing of Jenkins autobuild. - attempt #1
Gateway Microservice Application
Add development


---------------------------
Endpoints

AuthController:
    getUserRoleInfo:    api/v2/userRoleinfo
    logout:             api/v2/logout

BatchController:                        /api/v2/batch    
    retrieveBatch(use GET method):      /{id}
    deleteBatch(use DELETE method):     /{id}
    retrieveAllBatches:
    updateBatch:

BuildingController:                 /api/v2/building
    createBuilding:
    retrieveBuilding:               /{id}
    updateBuilding:         
    deleteBuilding:                 /{id}
    retrieveAllBuildings:           
    
    