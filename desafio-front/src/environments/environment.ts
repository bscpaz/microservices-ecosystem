import { Constants } from 'src/app/shared/common/constants';

export const environment = {
	production: false,
	baseHref: '/',
	apis: {
		apiUrl: 'http://localhost:8082/',
	},
	client_name: 'Bruno Paz',
	system_name: 'Desafio',
	system_version: Constants.SYSTEM_VERSION
};
