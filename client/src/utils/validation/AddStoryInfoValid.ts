const validIntroduce = (keyword: string) => {
  return keyword.length >= 1;
};

const validTotalAmount = (keyword: string) => {
  const numericPart = keyword.replace(/\D/g, '');
  if (keyword.length !== numericPart.length) {
    return false;
  }

  return true;
};

export { validIntroduce, validTotalAmount };
