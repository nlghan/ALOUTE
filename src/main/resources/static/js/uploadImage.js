import { initializeApp } from "https://www.gstatic.com/firebasejs/9.0.1/firebase-app.js";
import { getStorage, ref, uploadBytes, getDownloadURL } from "https://www.gstatic.com/firebasejs/9.0.1/firebase-storage.js";

const firebaseConfig = {
	key: "AIzaSyAktz6fBLYH1GcUykJi8JF5WHwI6dNncuY",
	apiKey: "AIzaSyAktz6fBLYH1GcUykJi8JF5WHwI6dNncuY",
	authDomain: "chatrealtime-7e7e8.firebaseapp.com",
	databaseURL: "https://chatrealtime-7e7e8-default-rtdb.firebaseio.com",
	projectId: "chatrealtime-7e7e8",
	storageBucket: "chatrealtime-7e7e8.appspot.com",
	messagingSenderId: "206925157542",
	appId: "1:206925157542:web:7e254501d41af820ed9067",
	measurementId: "G-0PDLXSS9SN",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const storage = getStorage();

// Add event listener for file input change
const fileInput = document.getElementById("file");
const imageContainer = document.getElementById("imageContainer");
const avataInput = document.querySelector("input[name='avataGroup']");

fileInput.addEventListener("change", async () => {
	const file = fileInput.files[0];

	if (file) {
		// đăng ảnh lên firebase
		const storageRef = ref(storage, file.name);
		try {
			const snapshot = await uploadBytes(storageRef, file);

			// Get the download URL of the uploaded image
			const downloadURL = await getDownloadURL(storageRef);

			// Set the value of the "avata" input field to the download URL
			avataInput.value = downloadURL;

			// hiển thị ảnh lên
			imageContainer.innerHTML = `<img src="${downloadURL}" alt="Uploaded Image" id="urlImage" style="width: 300px; height: 200px;">`;
		} catch (error) {
		}
	}
});