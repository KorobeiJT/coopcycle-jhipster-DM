import { element, by, ElementFinder } from 'protractor';

export class SystemePaiementComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-systeme-paiement div table .btn-danger'));
  title = element.all(by.css('jhi-systeme-paiement div h2#page-heading span')).first();
  noResult = element(by.id('no-result'));
  entities = element(by.id('entities'));

  async clickOnCreateButton(): Promise<void> {
    await this.createButton.click();
  }

  async clickOnLastDeleteButton(): Promise<void> {
    await this.deleteButtons.last().click();
  }

  async countDeleteButtons(): Promise<number> {
    return this.deleteButtons.count();
  }

  async getTitle(): Promise<string> {
    return this.title.getAttribute('jhiTranslate');
  }
}

export class SystemePaiementUpdatePage {
  pageTitle = element(by.id('jhi-systeme-paiement-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));

  crediteurInput = element(by.id('field_crediteur'));
  debiteurInput = element(by.id('field_debiteur'));
  methodInput = element(by.id('field_method'));

  compteSelect = element(by.id('field_compte'));

  async getPageTitle(): Promise<string> {
    return this.pageTitle.getAttribute('jhiTranslate');
  }

  async setCrediteurInput(crediteur: string): Promise<void> {
    await this.crediteurInput.sendKeys(crediteur);
  }

  async getCrediteurInput(): Promise<string> {
    return await this.crediteurInput.getAttribute('value');
  }

  async setDebiteurInput(debiteur: string): Promise<void> {
    await this.debiteurInput.sendKeys(debiteur);
  }

  async getDebiteurInput(): Promise<string> {
    return await this.debiteurInput.getAttribute('value');
  }

  async setMethodInput(method: string): Promise<void> {
    await this.methodInput.sendKeys(method);
  }

  async getMethodInput(): Promise<string> {
    return await this.methodInput.getAttribute('value');
  }

  async compteSelectLastOption(): Promise<void> {
    await this.compteSelect.all(by.tagName('option')).last().click();
  }

  async compteSelectOption(option: string): Promise<void> {
    await this.compteSelect.sendKeys(option);
  }

  getCompteSelect(): ElementFinder {
    return this.compteSelect;
  }

  async getCompteSelectedOption(): Promise<string> {
    return await this.compteSelect.element(by.css('option:checked')).getText();
  }

  async save(): Promise<void> {
    await this.saveButton.click();
  }

  async cancel(): Promise<void> {
    await this.cancelButton.click();
  }

  getSaveButton(): ElementFinder {
    return this.saveButton;
  }
}

export class SystemePaiementDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-systemePaiement-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-systemePaiement'));

  async getDialogTitle(): Promise<string> {
    return this.dialogTitle.getAttribute('jhiTranslate');
  }

  async clickOnConfirmButton(): Promise<void> {
    await this.confirmButton.click();
  }
}
