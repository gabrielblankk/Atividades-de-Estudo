#include <iostream>
using namespace std;

bool again() {
	int choose;
	bool valid = false;
	
	while (!valid) {
		cout << "Deseja realizar outra operação?" << endl;
		cout << "1 - Sim" << endl;
		cout << "2 - Não" << endl;
		cin >> choose;
	
		switch (choose) {
			case 1:
				system("clear");
				return true;
				valid = true;
				break;
			case 2:
				return false;
				valid = true;
				break;
			default:
				cout << "Digite uma opção válida." << endl << endl;
				valid = false;
				break;
		}
	}
}

void equivalentResistance() {
	int type, quantity;
	
	cout << "1 - Paralelo" << endl;
	cout << "2 - Série" << endl;
	cin >> type;
	cout << "Insira a quantidade de resistores: " << endl;
	cin >> quantity;
	
	float resistors[quantity];

	for (int i = 0; i < quantity; i++) {
		cout << "Insira o valor do resistor R" << i + 1 << ": " << endl;
		cin >> resistors[i];
	}
	
	float result = 0;
	
	if (type == 1) {
		for (int i = 0; i < quantity; i++) {
			result += (1 / resistors[i]);
		}
		result = 1 / result;
	} else if (type == 2) {
		for (int i = 0; i < quantity; i++) {
			result += resistors[i];
		}
	}
	cout << endl << "Req = " << result << " ohms" << endl << endl;
}

void resistance() {
	float voltage, current;

	cout << "Insira a tensão: " << endl;
	cin >> voltage;
	cout << "Insira a corrente: " << endl;
	cin >> current;

	float result = voltage / current;
	
	cout << "R = " << result << " ohms" << endl << endl;
}

void current() {
	float voltage, resistance;

	cout << "Insira a tensão: " << endl;
	cin >> voltage;
	cout << "Insira a resistência: " << endl;
	cin >> resistance;

	float result = voltage / resistance;

	cout << "i = " << result << " A" << endl << endl;
}

void voltage() {
	float current, resistance;

	cout << "Insira a corrente: " << endl;
	cin >> current;
	cout << "Insira a resistência:" << endl;
	cin >> resistance;

	float result = current * resistance;

	cout << "U = " << result << " V" << endl << endl;
}

void wattage() {
	float current, voltage;

	cout << "Insira a tensão: " << endl;
	cin >> voltage;
	cout << "Insira a corrente: " << endl;
	cin >> current;

	float result = voltage * current;

	cout << "P = " << result << " w" << endl << endl;
}

int main(void) {
	setlocale(LC_ALL, "Portuguese");

	while (true) {
		int choose;

		cout << "Série - Corrente Igual" << endl << "Paralelo - Tensão igual" << endl << endl;
		cout << "O que deseja calcular? " << endl << endl;
		cout << "1 - Resistência equivalente" << endl;
		cout << "2 - Resistência" << endl;
		cout << "3 - Corrente" << endl;
		cout << "4 - Tensão" << endl;
		cout << "5 - Potência" << endl;
		cin >> choose;
	
		switch (choose) {
			case 1:
				equivalentResistance();
				break;
			case 2:
				resistance();
				break;
			case 3:
				current();
				break;
			case 4:
				voltage();
				break;
			case 5:
				wattage();
				break;
			default:
				cout << "Insira uma opção válida." << endl << endl;
				break;
		}
		if (!again()) {
			break;
		}
	}

	return 0;
}