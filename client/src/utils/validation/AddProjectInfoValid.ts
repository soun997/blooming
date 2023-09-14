const validCompanyRegistrationNumber = (keyword: string) => {
  if (keyword.length === 10) {
    return true;
  }
  return false;
};

export { validCompanyRegistrationNumber };
