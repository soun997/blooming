const validFundingTitleCheck = (keyword: string) => {
  return 0 < keyword.length && keyword.length <= 30;
};

export { validFundingTitleCheck };
