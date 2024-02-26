//GABRIEL PENNA BASTOS BLANK & JUAN CARLOS SIMOES SOARES

//gabriel = login, registro, validações de info e main function
//juan = funções das abas

// bibliotecas usadas
#include <iostream>
#include <string>
#include <vector>
#include <unistd.h>
#include <time.h>

using namespace std;

// declaração da função main para chama-la
int main();

// simulando dados em um banco de dados
vector<vector<string>> accounts;
vector<vector<string>> connectedDevices;
vector<vector<string>> addedRoutines;
vector<string> questions;

//variaveis usadas enquanto o programa roda
int id;
bool connectedWifi = false;

//função para o usuário entrar com o login
bool login() {
	string username, password;
	bool exist = false;

	//verifica se há usuarios ou não
	if (accounts.size() == 0) {
		system("clear");
		cout << "⚠️  Não existem usuários ainda." << endl << endl;
		return false;
	}

	while (true) {
		cout << "🚪-ENTRAR-🚪" << endl << endl;
		cout << "Digite o nome do usuário: " << endl;
		getline(cin >> ws, username);

		//verifica o nome do usuario
		for (int i = 0; i < accounts.size(); i++) {
			if (username == accounts[i][0]) {
				exist = true;
				//cria um limite de tentativas para senha
				int count = 0;
				while (count < 3) {
					cout << "Insira a senha: " << endl;
					getline(cin >> ws, password);

					// se acertar retorna verdadeiro para entrar
					if (password == accounts[i][1]) {
						system("clear");
						id = i;
						return true;
						break;
					} else {
						count ++;
						if (count < 3) {
							cout << "⚠️  Senha incorreta, tente novamente." << endl << endl;
						} else {
							// caso erre todas, volta para a tela inicial
							system("clear");
							cout << "⚠️  Muitas tentativas incorretas, sessão encerrada." << endl << endl;
							return false;
							break;
						}
					}
				}
			}
			
		}
		//diz se o nome do usuario existe em uma conta
		if (!exist) {
			system("clear");
			cout << "⚠️  Usuário inexistente." << endl << endl;
		}
	}
}

//valida a entrada de email do usuario
bool validateEmail(string email) {
	int atSign = 0, dot = 0, atPos;
	
	for (int i = 0; i < email.length(); i++) {
		if (email[i] == ' ') {
			return false;
			break;
		} else {
			if (email[i] == '@') {
				if (!atSign && i > 2) {
					atSign = 1;
					atPos = i;
				} else {
					return false;
					break;
				}
			} else if (email[i] == '.') {
				if (i <= (atPos + 2)) {
					return false;
					break;
				} else {
					dot++;
				}
			}
		}
	} 

	// se tem os criterios de email retorna verdadeiro
	if (atSign != 1 || dot < 1) {
		return false;
	} else {
		return true;
	}
}

//Confere se a data que o usuário digitou é valida
bool validateDate(string date) {
	time_t mytime;
    mytime = time(NULL);
    struct tm tm = *localtime(&mytime);
	
	bool validFormat = true;

	if (date.length() != 10 || date[2] != '/' || date[5] != '/') {
		validFormat = false;
	} else {
		for (int i = 0; i < 10; i ++) {
			if (date[i] != '/' && !isdigit(date[i])) {
				validFormat = false;
			}
		}
	}

	if (validFormat) {
		int day, month, year, monthDays;

		day = stoi(date.substr(0, 2));
		month = stoi(date.substr(3, 2));
		year = stoi(date.substr(6, 4));

		if (year < 1900 || year > 2023 || month > 12 || month < 1) {
			return false;
		} else {
			switch (month) {
				case 2:
					!year % 4 ?  monthDays = 29 : monthDays = 28;
					break;
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					monthDays = 31;
					break;
				case 4: case 6: case 9: case 11:
					monthDays = 30;
					break;
			}
			// se cumpre os criterios de data retorna verdadeiro
			if (day > monthDays || (tm.tm_year + 1900) - year < 12) {
				return false;
			} else {
				return true;
			}
		}
	} else {
		return false;
	}
}

// valida as entradas de endereço do usuario
bool validateAddress(string city, string number, string state) {
	for (int i = 0; i < number.length(); i++) {
		if (isalpha(number[i])) {
			return false;
		} else if (city.length() > 60) {
			return false;
		} else if (state.length() != 2 || isdigit(state[i])) {
			return false;
		} else {
			return true;
		}
	}
}
//Valida o nome do usuario
bool validateUsername(string username) {
	return username.length() > 20 ? false : true; 
}

//verifica se a senha cumpre os requisitos
bool validatePassword(string password) {
	bool hasNumber = false;
	bool hasLetter = false;
	
	if (password.length() < 10) {
		return false;
	} else {
		for (int i = 0; i < password.length(); i++) {
			if (password[i] == ' ') {
				return false;
			}
			
			if (isdigit(password[i])) {
				hasNumber = true;
			}

			if (isalpha(password[i])) {
				hasLetter = true;
			}
		}

		if (hasNumber && hasLetter) {
			return true;
		} else {
			return false;
		}
	}
}

// funcao que pergunta e valida as entradas de registro de uma conta
bool registerAccount() {
	string email, date, username, password;

	cout << "✏️-REGISTRO DE CONTA-✏️" << endl;

	//loops que pedem as entradas até estar tudo certo
	bool validEmail;
	do {
		cout << endl << "Insira seu e-mail: " << endl;
		getline(cin >> ws, email);
		if (validateEmail(email)) {
			validEmail = true;
			system("clear");
			cout << "✏️-REGISTRO DE CONTA-✏️" << endl;
		} else {
			validEmail = false;
			system("clear");
			cout << "✏️-REGISTRO DE CONTA-✏️" << endl;
			cout << "⚠️  E-mail inválido." << endl;
		}
	} while (!validEmail);

	bool validDate;
	do {
		cout << endl << "Insira sua data de nascimento: (Mínimo 12 anos de idade)" << endl;
		getline(cin >> ws, date);
		if (validateDate(date)) {
			validDate = true;
			system("clear");
			cout << "✏️-REGISTRO DE CONTA-✏️" << endl;
		} else {
			validDate = false;
			system("clear");
			cout << "✏️-REGISTRO DE CONTA-✏️" << endl;
			cout << "⚠️  Data inválida ou idade inválida." << endl;
		}
	} while (!validDate);

	bool validAddress;
	string city, state, street, number;
	do {
		cout << endl << "--Informações do endereço--" << endl;
		cout << "Estado: " << endl;
		getline(cin >> ws, state);
		cout << "Cidade: " << endl;
		getline(cin >> ws, city);
		cout << "Rua: " << endl;
		getline(cin >> ws, street);
		cout << "Número: " << endl;
		getline(cin >> ws, number);
		
		if (validateAddress(city, number, state)) {
			validAddress = true;
			system("clear");
			cout << "✏️-REGISTRO DE CONTA-✏️" << endl;
		} else {
			validAddress = false;
			system("clear");
			cout << "✏️-REGISTRO DE CONTA-✏️" << endl;
			cout << "⚠️  Dados de endereço inválidos." << endl;
		}
	} while (!validAddress);

	bool validUsername;
	do {
		cout << endl << "Crie seu nome de usuário: " << endl;
		getline(cin >> ws, username);
		if (validateUsername(username)) {
			validUsername = true;
			system("clear");
			cout << "✏️-REGISTRO DE CONTA-✏️" << endl;
		} else {
			validUsername = false;
			system("clear");
			cout << "✏️-REGISTRO DE CONTA-✏️" << endl;
			cout << "⚠️  Seu nome de usuário não está disponível ou não cumpre os requisitos." << endl;
		}
	} while (!validUsername);

	bool validPassword;
	do {
		cout << endl << "Crie uma senha: " << endl << "(Deve ter pelo menos 10 caracteres contendo números e letras)" << endl;
		getline(cin >> ws, password);
		if (validatePassword(password)) {
			validPassword = true;
			system("clear");
		} else {
			validPassword = false;
			system("clear");
			cout << "✏️-REGISTRO DE CONTA-✏️" << endl;
			cout << "⚠️  A senha não cumpre os requisitos." << endl;
		}
	} while (!validPassword);

	//se tudo for válido, adiciona ao banco de dados
	accounts.push_back({{username}, {password}, {email}});
	
	cout << "✅  Conta criada com sucesso!" << endl << endl;
	return true;
}

//tela inicial que pergunta qual ação o usuario quer 
bool loginScreen() {	
	bool valid;
	int choose;
	
	do {
		cout << "---CONTROL---" << endl << endl << endl;
		cout << "🔑-LOGIN-🔑" << endl << endl;
		cout << "1 - Entrar" << endl;
		cout << "2 - Registrar" << endl;
		cout << "3 - Cancelar" << endl;

		// impede que o usuario escreva letras (aparece varias vezes no codigo)
		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		//leva o usuario aonde ele pediu
		switch (choose) {
			case 1:
				valid = true;
				system("clear");
				if (login()) {
					return true;
				}
				break;
			case 2:
				valid = true;
				system("clear");
				registerAccount();
				break;
			case 3:
				valid = true;
				return false;
				break;
			default:
				valid = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!valid);
}

//Função da tela da conta/perfil do usuário
bool account() {
	bool back;
	int choose;
	
	do {
		cout << "👤-CONTA-👤" << endl << endl;
		cout << "(Foto do Perfil)" << endl;
		//mostra as informações do usuario
		cout << accounts[id][0] << endl;
		cout << accounts[id][2] << endl << endl;
		cout << "1 - Voltar" << endl;
		cout << "2 - Sair" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			case 2:
				back = true;
				system("clear");
				//limpa o "bando de dados"
				connectedDevices.clear();
				addedRoutines.clear();
				connectedWifi = false;
				return false;
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
}

//funcao de conectar ao wifi
string wifiPassword = "senha123";
bool wifi() {
	bool back;
	int choose;

	do {
		cout << "📶-WIFI-📶" << endl << endl;
		cout << "Escolha uma rede: " << endl;
		cout << "1 - WiFi SENAI" << endl;
		cout << "2 - Voltar" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		bool valid;
		string password;

		// pede a senha do wifi
		switch (choose) {
			case 1:
				do {
					cout << "Insira a senha: " << endl;
					getline(cin >> ws, password);
					if (password != wifiPassword) {
						valid = false;
						cout << "⚠️  Senha incorreta." << endl;
					} else {
						valid = true;
						system("clear");
						cout << "✅  Wifi conectado." << endl;
						connectedWifi = true;
						return true;
					}
				} while (!valid);
				break;
			case 2: 
				back = true;
				system("clear");
				return true;
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
	
	
}

//função da tela de configurações
string notifications = "Ligado", sound = "Ligado", theme = "Dark", temp = "C°", timeZone = "Brasil";
bool configurations() {
	bool back;
	int choose;
	
	do {
		cout << "⚙️ -CONFIGURAÇÔES-⚙️" << endl << endl;
		cout << "1 - Voltar" << endl;
		cout << "2 - Notificações - " << notifications << endl;
		cout << "3 - Som - " << sound << endl;
		cout << "4 - Tema - " << theme << endl;
		cout << "5 - Unidade de temperatura - " << temp << endl;
		cout << "6 - Fuso horário - " << timeZone << endl;
		cout << "7 - WiFi" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		//cada opção muda uma configuração
		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			case 2:
				back = false;
				if (notifications == "Ligado") {
					notifications = "Desligado";
				} else if (notifications == "Desligado") {
					notifications = "Ligado";
				}
				system("clear");
				break;
			case 3:
				back = false;
				if (sound == "Ligado") {
					sound = "Desligado";
				} else if (sound == "Desligado") {
					sound = "Ligado";
				}
				system("clear");
				break;
			case 4:
				back = false;
				if (theme == "Dark") {
					theme = "Light";
				} else if (theme == "Light") {
					theme = "Dark";
				}
				system("clear");
				break;
			case 5:
				back = false;
				if (temp == "C°") {
					temp = "F°";
				} else if (temp == "F°") {
					temp = "C°";
				}
				system("clear");
				break;
			case 6:
				back = false;
				system("clear");
				cout << "Insira seu fuso horário: " << endl;
				getline(cin >> ws, timeZone);
				system("clear");
				break;
			case 7:
				system("clear");
				if (wifi()) {
					back = false;
				}
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);	
}

//funcao para adicionar um dispositivo
bool addDevice() {
	bool valid;
	int choose;
	string code, name, type;
	
	do {
		cout << "➕-ADICIONAR DISPOSITIVO-➕" << endl << endl;
		cout << "1 - Luz" << endl;
		cout << "2 - Porta/Janela" << endl;
		cout << "3 - Eletrodoméstico" << endl;
		cout << "4 - Câmera" << endl;
		cout << "5 - Voltar" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		//determina o tipo do dispositivo
		switch (choose) {
			case 1:
				valid = true;
				type = "Luz";
				break;
			case 2:
				valid = true;
				type = "Porta/Janela";
				break;
			case 3:
				valid = true;
				type = "Eletrodoméstico";
				break;
			case 4:
				valid = true;
				type = "Câmera";
				break;
			case 5:
				valid = true;
				system("clear");
				return true;
				break;
			default:
				valid = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!valid);

	//adiciona o dispositivo no bando de dados
	cout << "Insira o código do produto: " << endl;
	getline(cin >> ws, code);
	cout << endl << "Adicionando dispositivo..." << endl << endl;
	sleep(2);
	cout << "Digite o nome do dispositivo: " << endl;
	getline(cin >> ws, name);

	connectedDevices.push_back({{type}, {name}});
	system("clear");
	return false;
}

// variaveis usadas para simular os controles
string lightOnOff = "Desligado", lightColor = "Branco", lightBright = "100%";
string doorOpenClosed = "Fechada", doorLocked = "Destrancada";
string applianceOnOff = "Desligado", applianceFunction = "Desativada";
string cameraOnOff = "Ligado", cameraMove = "Esquerda";

//funcao de controlar os dispositivos
bool control() {
	bool back, valid;
	int choose, deviceChoose;
	string state = "Desligado";
	string types[connectedDevices.size()];

	do {
		cout << "🎚️-CONTROLE-🎚️" << endl << endl;
		cout << "Qual dispositivo deseja controlar?" << endl;
		for (int i = 0; i < connectedDevices.size(); i++) {
			cout << i+1 << " - " << connectedDevices[i][1] << endl;
			types[i] = connectedDevices[i][0];
		}

		//valida o dispositivo escolhido
		if (!(cin >> deviceChoose) || deviceChoose > connectedDevices.size()) {
			valid = false;
			cin.clear();
			cin.ignore(500, '\n');
			system("clear");
			cout << "⚠️  Insira uma opção válida." << endl;
		} else {
			valid = true;
		}
	} while (!valid);

	system("clear");

	//controles mudam dependendo do tipo
	do {
		cout << "🎚️-CONTROLE-🎚️" << endl << endl;
		if (types[deviceChoose - 1] == "Luz") {
			cout << "1 - Ligar/Desligar - " << lightOnOff << endl;
			cout << "2 - Mudar cor - " << lightColor << endl;
			cout << "3 - Mudar brilho - " << lightBright << endl;
			cout << "4 - Voltar" << endl;

			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}

			switch (choose) {
				case 1:
					back = false;
					system("clear");
					if (lightOnOff == "Desligado") {
						lightOnOff = "Ligado";
					} else if (lightOnOff == "Ligado") {
						lightOnOff = "Desligado";
					}
					break;
				case 2:
					back = false;
					system("clear");
					if (lightColor == "Branco") {
						lightColor = "Laranja";
					} else if (lightColor == "Laranja") {
						lightColor = "Branco";
					}
					break;
				case 3:
					back = false;
					system("clear");
					if (lightBright == "100%") {
						lightBright = "50%";
					} else if (lightBright == "50%") {
						lightBright = "0%";
					} else if (lightBright == "0%") {
						lightBright = "100%";
					}
					break;
				case 4:
					back = true;
					system("clear");
					return true;
					break;
				default:
					back = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		} else if (types[deviceChoose - 1] == "Porta/Janela") {
			cout << "1 - Fechar/Abrir - " << doorOpenClosed << endl;
			cout << "2 - Trancar - " << doorLocked << endl;
			cout << "3 - Voltar" << endl;
			
			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}

			switch (choose) {
				case 1:
					back = false;
					system("clear");
					if (doorOpenClosed == "Fechada") {
						doorOpenClosed = "Aberta";
					} else if (doorOpenClosed == "Aberta") {
						doorOpenClosed = "Fechada";
					}
					break;
				case 2:
					system("clear");
					back = false;
					if (doorLocked == "Destrancada") {
						doorLocked = "Trancada";
					} else if (doorLocked == "Trancada") {
						doorLocked = "Destrancada";
					}
					break;
				case 3:
					back = true;
					system("clear");
					return true;
					break;
				default:
					back = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		} else if (types[deviceChoose - 1] == "Eletrodoméstico") {
			cout << "1 - Ligar/Desligar - " << applianceOnOff << endl;
			cout << "2 - Função Especial - " << applianceFunction << endl;
			cout << "3 - Voltar" << endl;
			
			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}

			switch (choose) {
				case 1:
					back = false;
					system("clear");
					if (applianceOnOff == "Desligado") {
						applianceOnOff = "Ligado";
					} else if (applianceOnOff == "Ligado") {
						applianceOnOff = "Desligado";
					}
					break;
				case 2:
					back = false;
					system("clear");
					if (applianceFunction == "Desativada") {
						applianceFunction = "Ativa";
					} else if (applianceFunction == "Ativa") {
						applianceFunction = "Desativada";
					}
					break;
				case 3:
					back = true;
					system("clear");
					return true;
					break;
				default:
					back = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		} else if (types[deviceChoose - 1] == "Câmera") {
			cout << "1 - Ligar/Desligar - " << cameraOnOff << endl;
			cout << "2 - Mover - " << cameraMove << endl;
			cout << "3 - Voltar" << endl;
			
			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}

			switch (choose) {
				case 1:
					back = false;
					system("clear");
					if (cameraOnOff == "Ligado") {
						cameraOnOff = "Desligado";
					} else if (cameraOnOff == "Desligado") {
						cameraOnOff = "Ligado";
					}
					break;
				case 2:
					back = false;
					system("clear");
					if (cameraMove == "Esquerda") {
						cameraMove = "Direita";
					} else if (cameraMove == "Direita") {
						cameraMove = "Esquerda";
					}
					break;
				case 3:
					back = true;
					system("clear");
					return true;
					break;
				default:
					back = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		}
	} while (!back);
}

//Função para mostrar os dispositivos conectados
bool showDevices() {
	bool back;
	int choose;

	do {
		//verifica se há dispositivos e mostra todos separadamente
		if (connectedDevices.size() == 0) {
			cout << "⚠️  Não há dispositivos conectados." << endl;
			return true;
		} else {
			cout << "📲-DISPOSITIVOS CONECTADOS-📲" << endl << endl;
			cout << "Luzes" << endl;
			for (int i = 0; i < connectedDevices.size(); i++) {
				if (connectedDevices[i][0] == "Luz") {
					cout << "-" << connectedDevices[i][1] << endl;
				}
			}
	
			cout << endl << "Portas/Janelas" << endl;
			for (int i = 0; i < connectedDevices.size(); i++) {
				if (connectedDevices[i][0] == "Porta/Janela") {
					cout << "-" << connectedDevices[i][1] << endl;
				}
			}
	
			cout << endl << "Eletrodomésticos" << endl;
			for (int i = 0; i < connectedDevices.size(); i++) {
				if (connectedDevices[i][0] == "Eletrodoméstico") {
					cout << "-" << connectedDevices[i][1] << endl;
				}
			}

			cout << endl << "Câmeras" << endl;
			for (int i = 0; i < connectedDevices.size(); i++) {
				if (connectedDevices[i][0] == "Câmera") {
					cout << "-" << connectedDevices[i][1] << endl;
				}
			}
		}

		cout << endl << "1 - Voltar" << endl;
		cout << "2 - Controlar dispositivo" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		//pede se volta ou controla algum
		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			case 2:
				back = false;
				system("clear");
				control();
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
}

//funcao da aba de opções relacionadas a dispositivos
bool devices() {
	bool back;
	int choose;

	do {
		cout << "📱-DISPOSITIVOS-📱" << endl << endl;
		cout << "1 - Voltar" << endl;
		cout << "2 - Adicionar dispositivo" << endl;
		cout << "3 - Dispositivos conectados" << endl;
		
		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		//escolhe se vai adicionar ou ver os dispositivos
		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			case 2:
				system("clear");
				if (addDevice()) {
					back = true;
				}
				break;
			case 3:
				system("clear");
				if (showDevices()) {
					back = true;
				}
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
}

//Função para fazer rotinas
void addRoutine() {
	bool validDevice, validChoose, validTime;
	int choose, deviceChoose;
	string types[connectedDevices.size()], deviceName, action, time;

	do {
		cout << "➕-ADICIONAR ROTINA-➕" << endl << endl;
		cout << "Escolha o dispositivo desejado: " << endl;
		for (int i = 0; i < connectedDevices.size(); i++) {
			cout << i+1 << " - " << connectedDevices[i][1] << endl;
			types[i] = connectedDevices[i][0];
		}

		//valida o dispositivo escolhido
		if (!(cin >> deviceChoose) || deviceChoose > connectedDevices.size()) {
			validDevice = false;
			cin.clear();
			cin.ignore(500, '\n');
			system("clear");
			cout << "⚠️  Insira uma opção válida." << endl;
		} else {
			deviceName = connectedDevices[deviceChoose - 1][1];
			validDevice = true;
		}
	} while (!validDevice);

	system("clear");

	// cada dispositivo tem acoes proprias para rotinas
	do {
		cout << "➕-ADICIONAR ROTINA-➕" << endl << endl;
		cout << "Escolha a ação: " << endl;
		if (types[deviceChoose - 1] == "Luz") {
			cout << "1 - Ligar" << endl;
			cout << "2 - Desligar" << endl;
			cout << "3 - Mudar cor" << endl;
			cout << "4 - Mudar brilho" << endl;

			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}

			switch (choose) {
				case 1:
					validChoose = true;
					action = "Ligar";
					break;
				case 2:
					validChoose = true;
					action = "Desligar";
					break;
				case 3:
					validChoose = true;
					action = "Mudar cor";
					break;
				case 4:
					validChoose = true;
					action = "Mudar brilho";
					break;
				default:
					validChoose = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		} else if (types[deviceChoose - 1] == "Porta/Janela") {
			cout << "1 - Fechar" << endl;
			cout << "2 - Abrir" << endl;
			cout << "3 - Trancar" << endl;
			
			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}

			switch (choose) {
				case 1:
					validChoose = true;
					action = "Fechar";
					break;
				case 2:
					validChoose = true;
					action = "Abrir";
					break;
				case 3:
					validChoose = true;
					action = "Trancar";
					break;
				default:
					validChoose = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		} else if (types[deviceChoose - 1] == "Eletrodoméstico") {
			cout << "1 - Ligar" << endl;
			cout << "2 - Desligar" << endl;
			cout << "3 - (Funções únicas de cada um)";
			
			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}

			switch (choose) {
				case 1:
					validChoose = true;
					action = "Ligar";
					break;
				case 2:
					validChoose = true;
					action = "Desligar";
					break;
				case 3:
					validChoose = true;
					action = "Função especial";
					break;
				default:
					validChoose = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		} else if (types[deviceChoose - 1] == "Câmera") {
			cout << "1 - Ligar" << endl;
			cout << "2 - Desligar" << endl;
			cout << "3 - Mudar a direção" << endl;
			
			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}

			switch (choose) {
				case 1:
					validChoose = true;
					action = "Ligar";
					break;
				case 2:
					validChoose = true;
					action = "Desligar";
					break;
				case 3:
					validChoose = true;
					action = "Mover";
					break;
				default:
					validChoose = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		}
	} while (!validChoose);

	system("clear");

	//valida o horario da rotina
	do {
		cout << "➕-ADICIONAR ROTINA-➕" << endl << endl;
		cout << "Escolha um horário: (hh:mm)" << endl;
		getline(cin >> ws, time);

		for (int i = 0; i < time.length(); i++) {
			if (time.length() != 5 || time[2] != ':') {
				validTime = false;
				system("clear");
				cout << "⚠️  Insira um horário válido." << endl;
			} else if (time[i] != ':' && !isdigit(time[i])) {
				validTime = false;
				system("clear");
				cout << "⚠️  Insira um horário válido." << endl;
			} else {
				validTime = true;
				system("clear");
			}
		}

		//se tudo estiver certo ele adiciona no banco de dados
		if (validTime) {
			addedRoutines.push_back({{deviceName}, {action}, {time}});
		}
	} while (!validTime);
}

//funcao para mostrar as rotinas criadas
bool showRoutines() {
	bool back;
	int choose;

	do {
		//verifica se há rotinas
		if (addedRoutines.size() == 0) {
			cout << "⚠️  Não há rotinas criadas." << endl;
			return true;
		} else {
			cout << "⏱️ -MINHAS ROTINAS-⏱️" << endl << endl;
			for (int i = 0; i < addedRoutines.size(); i++) {
				cout << " - " << addedRoutines[i][0] << " - " << addedRoutines[i][1] << " - " << addedRoutines[i][2] << endl;
			}
			cout << endl << "1 - Voltar" << endl;
	
			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}
	
			switch (choose) {
				case 1:
					back = true;
					system("clear");
					return true;
					break;
				default:
					back = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		}
	} while (!back);
}

//funcao da aba que mostra as opções de rotinas
bool routines() {
	bool back;
	int choose;

	do {
		//verifica se há dispositivos
		if (connectedDevices.size() == 0) {
			cout << "⚠️  Não há dispositivos conectados." << endl;
			return true;
		} else {
			cout << "⏰-ROTINAS-⏰" << endl << endl;
			cout << "1 - Voltar" << endl;
			cout << "2 - Adicionar rotina" << endl;
			cout << "3 - Rotinas" << endl;
	
			if (!(cin >> choose)) {
				cin.clear();
				cin.ignore(500, '\n');
			}

			// escolhe se quer ver ou adicionar as rotinas
			switch (choose) {
				case 1:
					back = true;
					system("clear");
					return true;
					break;
				case 2:
					back = true;
					system("clear");
					addRoutine();
					break;
				case 3:
					back = true;
					system("clear");
					showRoutines();
					break;
				default:
					back = false;
					system("clear");
					cout << "⚠️  Insira uma opção válida." << endl;
					break;
			}
		} 
	} while (!back);
}

//Função da tela de informações
bool info() {
	srand(time(0));
	bool back;
	int choose;
	// gera informações aleatórias
	int randTemp = rand() % 30, randUmidity = rand() % 90, randEnergy = rand() % 1000;
	
	do {
		cout << "📋-INFORMAÇÔES-📋" << endl << endl;
		cout << "Temperatura: " << randTemp << " " << temp << endl;
		cout << "Umidade: " << randUmidity << " %" << endl;
		cout << "Clima: Levemente chuvoso" << endl;
		cout << "Energia gasta: " << randEnergy << " kW" << endl;
		cout << "1 - Voltar" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
}

//funcao que mostra as cameras
bool cameras() {
	bool back;
	int choose;

	do {
		cout << "📷-CÂMERAS-📷" << endl << endl;
		cout << "1 - Voltar" << endl;
		for (int i = 0; i < connectedDevices.size(); i++) {
			if (connectedDevices[i][0] == "Câmera") {
				cout << "- " << connectedDevices[i][1] << endl;
			}
		}

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
			system("clear");
			cout << "⚠️  Insira uma opção válida." << endl;
		}

		//escolhe se volta ou se ve as imagens da camera ao vivo (simulação)
		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			default:
				back = false;
				system("clear");
				cout << "(IMAGEM ROLANDO)" << endl;
				sleep(2);
				system("clear");
				break;
		}
	} while (!back);
}

//funcao da aba de historico de gravações
bool history() {
	bool back;
	int choose;

	//mostra arquivos de gravação simulados
	do {
		cout << "🧾-HISTÓRICO-🧾" << endl << endl;
		cout << "(Arquivos)" << endl;
		for (int i = 1; i < 12; i++) {
			cout << "Gravação #" << i << endl;
		}
		cout << "1 - Voltar" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
		
	} while (!back);
}

//Função para a aba de monitoramento
bool monitoring() {
	bool back;
	int choose;
	
	do {
		cout << "📺-MONITORAMENTO-📺" << endl << endl;
		cout << "1 - Voltar" << endl;
		cout << "2 - Câmeras" << endl;
		cout << "3 - Histórico" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		//escolhe se quer ver as cameras ou gravacoes
		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			case 2:
				system("clear");
				if (cameras()) {
					back = false;
				}
				break;
			case 3:
				system("clear");
				if (history()) {
					back = false;
				}
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
}

//funcao da aba de perguntas
bool faq() {
	bool back;
	int choose;

	//mostra as perguntas feitas
	do {
		cout << "❓-DÚVIDAS FREQUENTES-❓" << endl << endl;
		for (int i = 0; i < questions.size(); i++) {
			cout << questions[i] << endl; 
		}
		cout << "(Pergunta do usuário)" << endl;
		cout << "(Resposta da empresa)" << endl;
		cout << "(Pergunta do usuário)" << endl;
		cout << "(Resposta da empresa)" << endl;
		cout << "1 - Voltar" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
}

//funcao da aba de contato
bool contact() {
	bool back;
	int choose;

	//mostra informações de contato e pede alguma pergunta
	do {
		cout << "📞-CONTATO-📞" << endl << endl;
		cout << "Email: controlinc@gmail.com" << endl;
		cout << "Número: 9626-5751" << endl;
		cout << "1 - Voltar" << endl;
		cout << "2 - Enviar uma pergunta" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		string question;
		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			case 2:
				back = false;
				cout << "Pergunte: " << endl;
				getline(cin >> ws, question);
				//adiciona a pergunta ao banco
				questions.push_back({question});
				system("clear");
				cout << "✅  Sua pergunta foi enviada." << endl;
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
}

//funcao que mostra as opções para a aba de suporte
bool support() {
	bool back;
	int choose;
	
	do {
		cout << "🗣️ -SUPORTE-🗣️" << endl << endl;
		cout << "1 - Voltar" << endl;
		cout << "2 - Dúvidas frequentes" << endl;
		cout << "3 - Emergência" << endl;
		cout << "4 - Contato" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		//escolhe o que quer fazer
		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			case 2:
				system("clear");
				if (faq()) {
					back = false;
				}
				break;
			case 3:
				back = true;
				//simula uma emergencia
				for (int i = 50; i >= 0; i-=5) {
					system("clear");
					cout << "Os operários estão a " << i << "km de você." << endl;
					sleep(1);
				}
				system("clear");
				break;
			case 4:
				system("clear");
				if (contact()) {
					back = false;
				}
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
}

//Funçaõ para a aba de compras
bool shop() {
	bool back;
	int choose;

	//produtos aleatorios
	do {
		cout << "💳-COMPRAS-💳" << endl << endl;
		cout << "1 - Voltar" << endl;
		cout << "2 - Lâmpada Inteligente Control 5000 - Comprar - $224.99" << endl;
		cout << "3 - Porta Inteligente Control 2000 - Comprar - $669.99" << endl;
		cout << "4 - Ar Condicionado Inteligente Control 3000 - Comprar - $777.77" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		switch (choose) {
			case 1:
				back = true;
				system("clear");
				return true;
				break;
			case 2: case 3: case 4:
				back = false;
				//simula uma compra
				cout << "✅  Item comprado com sucesso." << endl;
				cout << "Tempo até a entrega: NUNCA" << endl;
				sleep(3);
				system("clear");
				break;
			default:
				back = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!back);
}

//tela principal onde mostra todas as opções de abas
bool mainScreen() {
	bool valid;
	int choose;

	//opçoes
	do {
		cout << "🏠-INÍCIO-🏠" << endl << endl;
		cout << "1 - Conta" << endl;
		cout << "2 - Configurações" << endl;
		cout << "3 - Dispositivos" << endl;
		cout << "4 - Rotinas" << endl;
		cout << "5 - Informações" << endl;
		cout << "6 - Monitoramento" << endl;
		cout << "7 - Suporte" << endl;
		cout << "8 - Compras" << endl;

		if (!(cin >> choose)) {
			cin.clear();
			cin.ignore(500, '\n');
		}

		//leva o usuario à função
		switch (choose) {
			case 1:
				system("clear");
				if (account()) {
					valid = false;
				} else {
					valid = true;
					return false;
				}
				break;
			case 2:
				system("clear");
				if (configurations()) {
					valid = false;
				}
				break;
			case 3:
				system("clear");
				valid = true;
				if (connectedWifi) {
					if (devices()) {
						valid = false;
					}
				} else {
					cout << "📶  Conecte no Wifi!" << endl;
				}
				break;
			case 4:
				system("clear");
				valid = true;
				if (routines()) {
					valid = false;
				}
				break;
			case 5:
				system("clear");
				valid = true;
				if (connectedWifi) {
					if (info()) {
						valid = false;
					}
				} else {
					cout << "📶  Conecte no Wifi!" << endl;
				}
				break;
			case 6:
				system("clear");
				valid = true;
				if (connectedWifi) {
					if (monitoring()) {
						valid = false;
					}
				} else {
					cout << "📶  Conecte no Wifi!" << endl;
				}
				break;
			case 7:
				system("clear");
				valid = true;
				if (connectedWifi) {
					if (support()) {
						valid = false;
					}
				} else {
					cout << "📶  Conecte no Wifi!" << endl;
				}
				break;
			case 8:
				system("clear");
				valid = true;
				if (connectedWifi) {
					if (shop()) {
						valid = false;
					}
				} else {
					cout << "📶  Conecte no Wifi!" << endl;
				}
				break;
			default:
				valid = false;
				system("clear");
				cout << "⚠️  Insira uma opção válida." << endl;
				break;
		}
	} while (!valid);
}

//funcao principal que chama as telas iniciais
int main() {
	do {
		if (loginScreen()) {
			mainScreen();
		} else {
			break;
		}
	} while (true);
	
	return 0;	
}