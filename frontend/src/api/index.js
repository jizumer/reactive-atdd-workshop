export const getStatus = async () => {
	try{
        const resp = await fetch('http://localhost:8080/status');
        return resp;
	}catch(error){
		throw error;
	}
}